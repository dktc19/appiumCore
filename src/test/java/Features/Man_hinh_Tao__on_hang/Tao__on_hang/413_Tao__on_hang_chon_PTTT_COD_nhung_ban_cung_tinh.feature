# Automation priority: null
# Test case importance: Low
# language: en
Feature: Tạo đơn hàng chọn PTTT COD nhưng bán cùng tỉnh

	Scenario Outline: Tạo đơn hàng chọn PTTT COD nhưng bán cùng tỉnh
		Given Login vào tk SPF thành công bằng bằng <Account>và <Password>
		When Truy cập màn hình Dịch vụ từ màn hình Menu
		And Nhập địa chỉ khách hàng
		And Chọn dịch vụ Smart Home
		And Di chuyển đến màn hình Tạo đơn hàng
		And Chọn phương thức thanh toán COD
		And Nhấn bút Tạo đơn hàng
		Then Hiển thị message: 'Bạn không được phép sử dụng phương thức thanh toán này'

		@1
		Examples:
		| Account | Password |
		| "HCM.VanMTT3" | "Test123456@" |