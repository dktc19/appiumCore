# Automation priority: null
# Test case importance: Low
# language: en
Feature: check nhập thông tin khách hàng doanh nghiệp thành công

	Scenario Outline: check nhập thông tin khách hàng doanh nghiệp thành công
		Given Tại màn hình Tạo đơn hàng, Tap button Cập nhật
		When Tap Button Thêm ảnh và thêm ảnh (Tối đa 5 ảnh)
		And Nhập <TenToChucDN> vào Tên tổ chức/doanh nghiệp
		And Nhập <MaSoThue> vào Mã số thuê/Mã số ĐKKD
		And Nhập <NgayCap> và <NoiCap> vào Ngày cấp và Nơi cấp
		And Nhập <NgayThanhLap> vào Ngày thành lập
		And Nhập <DiaChiTrenGPKD> vào Địa chỉ trên GPKD
		And Nhập <SDTToChuc> vào Số điện thoại tổ chức/doanh nghiệp
		And Nhập <SDTLienHe> vào Số điện thoại giao dịch, liên hệ
		And Nhập <HoTenNguoiDaiDien> vào Họ tên người đại diện
		And Tap button Xác nhận & Lưu
		Then Quay về màn hình Tạo đơn hàng và thông tin <TenToChucDN>, <MaSoThue>, <SDTToChuc> được lưu tại màn hình Tạo đơn hàng

		@1
		Examples:
		| DiaChiTrenGPKD | HoTenNguoiDaiDien | MaSoThue | NgayCap | NgayThanhLap | NoiCap | SDTLienHe | SDTToChuc | TenToChucDN |
		| "hcm" | "Linh Giang" | 15648456 | "12/04/2021" | "12/04/2021" | "hcm" | 0337189666 | 0337189666 | "Công ty ABC" |