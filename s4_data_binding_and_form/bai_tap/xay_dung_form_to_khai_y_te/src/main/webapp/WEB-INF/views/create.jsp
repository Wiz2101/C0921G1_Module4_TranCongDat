<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<header>
    <h3 class="text-center">TỜ KHAI Y TẾ</h3>
    <h5 class="text-center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN
        THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h5>
    <h5 class="text-center" style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm luật pháp Việt Nam và có
        thể xử lý hình sự</h5>
</header>
<div class="container">
    <form:form modelAttribute="person" action="/create" method="post">
        <div class="row">
            <div class="col-lg-12">
                <label class="fw-bold">Họ tên (ghi chữ IN HOA)<em style="color: red">(*)</em> </label>
                <form:input cssClass="form-control" path="name"></form:input>

            </div>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <label class="fw-bold">Năm sinh<em style="color: red">(*)</em> </label>
                <form:input cssClass="form-control" path="dOB"></form:input>
            </div>
            <div class="col-lg-4">
                <label class="fw-bold">Giới tính<em style="color: red">(*)</em> </label>
                <form:select cssClass="form-control" path="gender" items="${genderList}"></form:select>
            </div>
            <div class="col-lg-4">
                <label class="fw-bold">Quốc tịch<em style="color: red">(*)</em> </label>
                <form:input cssClass="form-control" path="nationality"></form:input>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <label class="fw-bold">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khách<em
                        style="color: red">(*)</em> </label>
                <form:input cssClass="form-control" path="id"></form:input>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <label class="fw-bold">Thông tin đi lại<em style="color: red">(*)</em></label>
                <br>
                <form:radiobutton value="TauBay" path="transportation"></form:radiobutton> Tàu bay
                <form:radiobutton value="TauThuyen" path="transportation"></form:radiobutton> Tàu thuyền
                <form:radiobutton value="Oto" path="transportation"></form:radiobutton> Ô tô
                <form:radiobutton value="Khac" path="transportation"></form:radiobutton> Khác (Ghi rõ)
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <label class="fw-bold">Số hiệu phương tiện</label>
                <form:input cssClass="form-control" path="vehicleId"></form:input>
            </div>
            <div class="col-lg-6">
                <label class="fw-bold">Số ghế</label>
                <form:input cssClass="form-control" path="seats"></form:input>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <label class="fw-bold">Ngày khởi hành<em style="color: red">(*)</em> </label>
                <form:input path="departure" cssClass="form-control"></form:input>
            </div>
            <div class="col-lg-6">
                <label class="fw-bold">Ngày kết thúc<em style="color: red">(*)</em> </label>
                <form:input path="arrival" cssClass="form-control"></form:input>
            </div>
        </div>
        <div class="row">
            <label class="fw-bold">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?<em
                    style="color: red">(*)</em> </label>
            <div class="col-lg-12">
                <form:textarea path="report" cssClass="form-control"></form:textarea>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <h5>Địa chỉ liên lạc</h5>
                <div class="row">
                    <div class="col-lg-4">
                        <label class="fw-bold">Tỉnh / thành<em style="color: red">(*)</em> </label>
                        <form:input path="province" cssClass="form-control"></form:input>
                    </div>
                    <div class="col-lg-4">
                        <label class="fw-bold">Quận / huyện<em style="color: red">(*)</em> </label>
                        <form:input path="district" cssClass="form-control"></form:input>
                    </div>
                    <div class="col-lg-4">
                        <label class="fw-bold">Phường / xã<em style="color: red">(*)</em> </label>
                        <form:input path="ward" cssClass="form-control"></form:input>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <label class="fw-bold">Địa chỉ nơi ở<em style="color: red">(*)</em> </label>
                <form:input path="address" cssClass="form-control"></form:input>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <label class="fw-bold">Điện thoại<em style="color: red">(*)</em> </label>
                <form:input path="phoneNumber" cssClass="form-control"></form:input>
            </div>
            <div class="col-lg-6">
                <label class="fw-bold">Email<em style="color: red">(*)</em> </label>
                <form:input path="email" cssClass="form-control"></form:input>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <label class="fw-bold">Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sao đây không?<em
                        style="color: red">(*)</em> </label>
                <div class="row">
                    <div class="col-lg-6">
                        <table style="width: 100%;" border="1">
                            <tr>
                                <th>Triệu chứng</th>
                                <th>Có</th>
                                <th>Không</th>
                            </tr>
                            <tr>
                                <td><label class="fw-bold">Sốt<em style="color: red">(*)</em> </label></td>
                                <td><form:radiobutton value="true" path="fever"></form:radiobutton></td>
                                <td><form:radiobutton value="false" path="fever"></form:radiobutton></td>
                            </tr>
                            <tr>
                                <td><label class="fw-bold">Ho<em style="color: red">(*)</em> </label></td>
                                <td><form:radiobutton value="true" path="cough"></form:radiobutton></td>
                                <td><form:radiobutton value="false" path="cough"></form:radiobutton></td>
                            </tr>
                            <tr>
                                <td><label class="fw-bold">Khó thở<em style="color: red">(*)</em> </label></td>
                                <td><form:radiobutton value="true" path="shortenBreath"></form:radiobutton></td>
                                <td><form:radiobutton value="false" path="shortenBreath"></form:radiobutton></td>
                            </tr>
                            <tr>
                                <td><label class="fw-bold">Đau họng<em style="color: red">(*)</em> </label></td>
                                <td><form:radiobutton value="true" path="soreThroat"></form:radiobutton></td>
                                <td><form:radiobutton value="false" path="soreThroat"></form:radiobutton></td>
                            </tr>
                        </table>
                    </div>
                    <div class="col-lg-6">
                        <table style="width: 100%;" border="1">
                            <tr>
                                <th>Triệu chứng</th>
                                <th>Có</th>
                                <th>Không</th>
                            </tr>
                            <tr>
                                <td><label class="fw-bold">Nôn/buồn nôn<em style="color: red">(*)</em> </label></td>
                                <td><form:radiobutton value="true" path="vomit"></form:radiobutton></td>
                                <td><form:radiobutton value="false" path="vomit"></form:radiobutton></td>
                            </tr>
                            <tr>
                                <td><label class="fw-bold">Tiêu chảy<em style="color: red">(*)</em> </label></td>
                                <td><form:radiobutton value="true" path="diarrhea"></form:radiobutton></td>
                                <td><form:radiobutton value="false" path="diarrhea"></form:radiobutton></td>
                            </tr>
                            <tr>
                                <td><label class="fw-bold">Xuất huyết ngoài da<em style="color: red">(*)</em> </label>
                                </td>
                                <td><form:radiobutton value="true" path="skinHemorrhage"></form:radiobutton></td>
                                <td><form:radiobutton value="false" path="skinHemorrhage"></form:radiobutton></td>
                            </tr>
                            <tr>
                                <td><label class="fw-bold">Nổi ban ngoài da<em style="color: red">(*)</em> </label></td>
                                <td><form:radiobutton value="true" path="skinRash"></form:radiobutton></td>
                                <td><form:radiobutton value="false" path="skinRash"></form:radiobutton></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <td><label class="fw-bold">Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có<em style="color: red">(*)</em>
                </label></td>
                <table style="width: 100%;" border="1">
                    <tr>
                        <th></th>
                        <th>Có</th>
                        <th>Không</th>
                    </tr>
                    <tr>
                        <td>Đến trang trại chăn nuôi/chợ buôn bán động vật sống/cơ sở giết mổ động vật/tiếp xúc động vật<em
                                style="color: red">(*)</em></td>
                        <td><form:radiobutton value="true" path="animalHistory"></form:radiobutton></td>
                        <td><form:radiobutton value="false" path="animalHistory"></form:radiobutton></td>
                    </tr>
                    <tr>
                        <td>Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV<em
                                style="color: red">(*)</em></td>
                        <td><form:radiobutton value="true" path="contactHistory"></form:radiobutton></td>
                        <td><form:radiobutton value="false" path="contactHistory"></form:radiobutton></td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <p>Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý của
                    Ban chỉ đạo quốc gia về Phòng chống dịch Covid-19.</p>
                <p>Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý</p>
            </div>
        </div>
        <input type="submit" value="GỬI TỜ KHAI" class="btn btn-success">
    </form:form>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>