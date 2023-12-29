# Automation priority: null
# Test case importance: Low
# language: en
Feature: Tạo đơn hàng - TH chọn PTTT COD nhưng tổng tiền = 0

	Scenario Outline: Tạo đơn hàng - TH chọn PTTT COD nhưng tổng tiền = 0
		Given Login vào tk SPF thành công bằng <Account> và <Password>
		When Truy cập màn hình Dịch vụ từ màn hình Menu
		And Nhập địa chỉ khách hàng
		And Chọn dịch vụ Smart Home với tổng tiền bằng 0
		And Di chuyển đến màn hình Tạo đơn hàng
		And Chọn phương thức thanh toán COD
		Then Hiển thị message: 'Tổng tiền dịch vụ/sản phẩm phải lớn hơn 0 đồng thì được phép sử dụng phương thức thanh toán COD.'

		@1
		Examples:
		| Account | Password |
		| "HCM.VanMTT3" | "Test123456@" |