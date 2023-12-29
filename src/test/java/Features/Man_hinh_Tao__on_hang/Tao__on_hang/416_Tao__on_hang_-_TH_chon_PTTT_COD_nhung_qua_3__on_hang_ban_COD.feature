# Automation priority: null
# Test case importance: Low
# language: en
Feature: Tạo đơn hàng - TH chọn PTTT COD nhưng quá 3 đơn hàng bán COD

	Scenario Outline: Tạo đơn hàng - TH chọn PTTT COD nhưng quá 3 đơn hàng bán COD
		Given Login vào tk SPF thành công bằng <Account> và <Password>
		When Tạo 3 đơn hàng có dịch vụ thanh toán bằng COD
		And Tạo một đơn hàng có dịch vụ thanh toán bằng COD
		Then Hiển thị message: 'Bạn không được phép sử dụng phương thức thanh toán này'

		@1
		Examples:
		| Account | Password |
		| "HCM.VanMTT3" | "Test123456@" |