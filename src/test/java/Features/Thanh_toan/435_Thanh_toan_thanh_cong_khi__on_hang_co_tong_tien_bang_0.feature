# Automation priority: null
# Test case importance: Low
# language: en
Feature: Thanh toán thành công khi Đơn hàng có tổng tiền bằng 0

	Scenario: Thanh toán thành công khi Đơn hàng có tổng tiền bằng 0
		Given Tại màn hình Thanh toán, Tap Button thanh toán
		When Check TH thanh toán thành công
		Then Gửi thông báo thanh toán thành công và chuyển sang màn hình thông báo thanh toán thành công với mã đơn hàng và số tiền tương ứng