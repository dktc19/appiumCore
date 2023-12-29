# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check tín hiệu thanh toán thành công trả về khi đang ở màn hình Thanh toán

	Scenario: Check tín hiệu thanh toán thành công trả về khi đang ở màn hình Thanh toán
		Given Tại màn hình Thanh toán, thực hiện thanh toán theo phương thức tiền mặt
		When Ở màn hình Thanh toán chờ tín hiệu
		Then Khi có tín hiệu thanh toán thành công thì mới gửi thông báo thanh toán thành công và chuyển sang màn hình thông báo thanh toán thành côngvới mã đơn hàng và số tiền tương ứng