<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="author" content="Untree.co" />
    <link rel="shortcut icon" href="favicon.png" />
    <meta name="description" content="" />
    <meta name="keywords" content="bootstrap, bootstrap4" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet" />
    <link href="static/css/tiny-slider.css" rel="stylesheet" />
    <link href="static/css/productDetail.css" rel="stylesheet" />
    <title>Product Detail</title>
</head>
<body>
<%@ include file="component/header.jsp" %>

<div class="hero">
    <div class="container" style="margin-top: 32px !important;">
        <div class="row justify-content-between">
            <div class="col-lg-5">
                <div class="intro-excerpt">
                    <h1>Detail</h1>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="we-help-section">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-lg-7 mb-5 mb-lg-0">
                <div class="imgs-grid">
                    <img src="https://ananas.vn/wp-content/uploads/Pro_AV00207_2.jpg" alt="Image" class="img-detail" id="productImage" />
                </div>
            </div>
            <div class="col-lg-5 ps-lg-5">
                <h2 class="section-title mb-4" id="productName">${productDetails[0].product_name}</h2>
                <p id="productDescription">${productDetails[0].description}</p>
                <p>Mã sản phẩm: <strong id="productId">${productDetails[0].product_detail_id}</strong></p>

                <h2 class="price" id="productPrice"><fmt:formatNumber value="${productDetails[0].price}" type="currency" currencySymbol="VND"/></h2>
                <hr class="dotted-separator" />

                <div class="ChooseColor">
                    <h3>Color</h3>
                    <div class="color" style="margin-right: 16px !important;">
                        <c:forEach var="productDetail" items="${productDetails}">
                            <input type="radio" id="color${productDetail.color_code}" name="color" value="${productDetail.color_code}" onclick="updateProductDetail(${productDetail.color_code})" />
                            <label class="color-label" for="color${productDetail.color_code}" style="background-color:
                            <c:choose>
                            <c:when test="${productDetail.color_code == 1}">#888154</c:when>
                            <c:when test="${productDetail.color_code == 2}">#c17137</c:when>
                            <c:when test="${productDetail.color_code == 3}">#434b60</c:when>
                            <c:otherwise>gray</c:otherwise>
                            </c:choose>; width: 32px; height: 32px; display: flex; justify-content: center;align-items: center; color: white; border-radius: 100%;margin-right: 16px !important">
                                    ${productDetail.color_code}
                            </label>
                        </c:forEach>
                    </div>
                </div>

                <hr class="dotted-separator" />

                <div class="ChooseDetail">
                    <div class="ChooseDetail-size">
                        <h3>Size</h3>
                        <select class="form-select" aria-label="Default select example" name="size" id="productSize">
                            <option selected>${productDetails[0].size}</option>
                        </select>
                    </div>

                    <div class="ChooseDetail-quantity">
                        <h3>Quantity</h3>
                        <input type="number" name="quantity" placeholder="input quantity" style="boder:none; border-radius: 10px"  required/>
                    </div>
                </div>
                <form action="addToCart" method="post" >
                    <input type="hidden" name="userId" value="${sessionScope.userId}" />
                    <input type="hidden" name="productId" id="hiddenProductId" value="${productDetails[0].product_detail_id}" />
                    <input type="hidden" name="quantity" id="hiddenQuantity" />
                    <p><button type="submit" class="btn btn-detail">Thêm vào giỏ hàng</button></p>
                </form>
            </div>
        </div>

        <div class="product-infor">
            <h2>Thông tin sản phẩm</h2>
            <p id="productInfoDescription">${productDetails[0].description}</p>
            <p>Color: <span id="productInfoColor">${productDetails[0].color_code}</span></p>
            <p>Size: <span id="productInfoSize">${productDetails[0].size}</span></p>
        </div>
    </div>
</div>

<%@ include file="component/footer.jsp" %>

<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/tiny-slider.js"></script>
<script src="js/custom.js"></script>
<script type="text/javascript">
    function updateProductDetail(colorCode) {
        console.log("=========colorCode==============", colorCode);
        var productDetails = [
            <c:forEach items="${productDetails}" var="item" >
            {imageUrl: '${item.imageUrl}', color_code: ${item.color_code}, price: ${item.price}, size: '${item.size}', quantity: ${item.quantity}, description: '${item.description}', product_detail_id: ${item.product_detail_id},
                product_name: '${item.product_name}'}
            </c:forEach>
        ];

        console.log(productDetails)
        const selectedProduct = productDetails.find(productDetail => productDetail.color_code === colorCode);

        if (selectedProduct) {
            document.getElementById('productImage').src = selectedProduct.imageUrl;
            document.getElementById('productName').innerText = selectedProduct.product_name;
            document.getElementById('productDescription').innerText = selectedProduct.description;
            document.getElementById('productId').innerText = selectedProduct.product_detail_id;
            document.getElementById('productPrice').innerText = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(selectedProduct.price);
            document.getElementById('productSize').innerHTML = `<option selected>${selectedProduct.size}</option>`;
            document.getElementById('productQuantity').innerHTML = `<option selected>${selectedProduct.quantity}</option>`;
            document.getElementById('productInfoDescription').innerText = selectedProduct.description;
            document.getElementById('productInfoColor').innerText = selectedProduct.color_code;
            document.getElementById('productInfoSize').innerText = selectedProduct.size;
        }
    }

    function addToCart() {
        const quantity = document.getElementById('quantity').value;
        document.getElementById('hiddenQuantity').value = quantity;
        return true;
    }
</script>
</body>
</html>