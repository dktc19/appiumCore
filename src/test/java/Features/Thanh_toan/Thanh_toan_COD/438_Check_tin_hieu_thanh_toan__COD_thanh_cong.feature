# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check tín hiệu thanh toán  COD thành công

	Scenario: Check tín hiệu thanh toán  COD thành công
		Given Tại màn hình thanh toán với dịch vụ Smart Home
		When Cập thêm thông tin tại màn hình Tạo đơn hàng và nhấn tạo đơn hàng
		And Tap button thanh toán
		Then Gửi thông báo thanh toán thành công và chuyển sang màn hình thông báo thanh toán thành công với mã đơn hàng và số tiền tương ứng