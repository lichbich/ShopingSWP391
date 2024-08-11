package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.common.BusinessCommon;
import com.vn.fpt.g1.shop.common.Pagination;
import com.vn.fpt.g1.shop.dao.ColorDao;
import com.vn.fpt.g1.shop.dto.ColorDto;
import com.vn.fpt.g1.shop.entity.ProductColor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(urlPatterns = {"/color/*"})
public class ColorServlet extends HttpServlet {
    private final ColorDao colorDao = new ColorDao();
    private String message = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getServletPath();
        String pathInfo = req.getPathInfo();

        if (action.equals("/color") && pathInfo != null) {
            action = pathInfo;
        } else if (action.equals("/color")) {
            action = "/";
        }
        try {
            switch (action) {
                case "/list-color":
                    listColor(req, resp);
                    break;
                case "/add-color":
                    insertColor(req, resp);
                    break;
                case "/new-color":
                    showNewForm(req, resp);
                    break;
//                case "/edit-post":
//                    showEditForm(request, response);
//                    break;
//                case "/update-post":
//                    updatePost(request, response);
//                    break;
//                case "/update-post-status":
//                    updatePostStatus(request, response);
//                    break;
                default:
                    RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                    dispatcher.forward(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    private void listColor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int page = 1;
        int size = 10;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(
                    request.getParameter("page"));
        }
        Pagination pagination = new Pagination(page, size);

        String colorNameRaw = request.getParameter("colorName");
        String colorCodeRaw = request.getParameter("colorCode");

        String colorName = colorNameRaw != null && !colorNameRaw.trim().isEmpty() ? colorNameRaw : "";
        String colorCode = colorCodeRaw != null && !colorCodeRaw.trim().isEmpty() ? colorCodeRaw : "";

        List<ColorDto> listColor = colorDao.listAllColor(pagination, colorName, colorCode);


        request.setAttribute("color", listColor);
        request.setAttribute("pagination", pagination);

        request.setAttribute("name_search", colorName);
        request.setAttribute("code_search", colorCode);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/color-management/color-page.jsp");
        dispatcher.forward(request, response);
    }

  private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/color-management/form-color.jsp");
        dispatcher.forward(request, response);
    }

//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("postId"));
//
//        int page = 1;
//        int recordsPerPage = 5;
//        if (request.getParameter("page") != null) {
//            page = Integer.parseInt(
//                    request.getParameter("page"));
//        }
//
//        Post existingPost = blogDao.getPostsById(id);
//        List<Settings> listSetting = settingDao.listType("Post Category");
//        request.setAttribute("settings", listSetting);
//
//        List<Report> reports = reportDao.listReports((page - 1) * recordsPerPage, recordsPerPage, id);
//        int noOfRecords = reportDao.getNoOfRecords();
//        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
//
//        request.setAttribute("noOfPages", noOfPages);
//        request.setAttribute("currentPage", page);
//        request.setAttribute("reports", reports);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("post/post-form.jsp");
//        request.setAttribute("post", existingPost);
//        dispatcher.forward(request, response);
//
//    }

    private void insertColor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        String nameRaw = request.getParameter("name");
        String codeRaw = request.getParameter("code");

        String name = nameRaw.trim();
        String code = codeRaw.trim();
        Date createdDate = Date.valueOf(LocalDate.now());
        Date updatedDate = Date.valueOf(LocalDate.now());

        ProductColor color = new ProductColor(0,1,name, code, createdDate, updatedDate);
        colorDao.addNewColor(color);
        message = "Add Success!";
        request.getSession().setAttribute("message", message);
        response.sendRedirect("list-color");
    }

//    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("postId"));
//
//        String title_raw = request.getParameter("title");
//        String content_raw = request.getParameter("content");
//        String userId_raw = request.getParameter("user_id");
//        String imageUrl_raw = request.getParameter("imageURL");
//        String status_raw = request.getParameter("status");
//        String createdDate_raw = request.getParameter("createdDate");
//        String settingId_raw = request.getParameter("setting_id");
//        //String updatedDate_raw = request.getParameter("createdDate");
//
//        String title = title_raw.trim();
//        String content = content_raw.trim();
//        int userId = Integer.parseInt(userId_raw.trim());
//        int settingId = Integer.parseInt(settingId_raw.trim());
//        String status = status_raw != null && !"".equals(status_raw.trim()) && "on".equals(status_raw) ? "Published" : "unpublished";
//        String imageUrl = imageUrl_raw.trim();
//        Date createdDate = Date.valueOf(createdDate_raw.trim());
//        Date updatedDate = Date.valueOf(LocalDate.now());
//
//        Post updatePost = new Post(id, title, content, userId, imageUrl, status, createdDate, settingId, updatedDate);
//
//        blogDao.updatePost(updatePost);
//        message = "Update Success!";
//        request.getSession().setAttribute("message", message);
//        response.sendRedirect("list-post");
//    }
}
