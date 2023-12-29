# Automation priority: null
# Test case importance: Low
# language: en
Feature: Thay đổi thông tin địa chỉ ,Đối tượng khách hàng

	Scenario: Thay đổi thông tin địa chỉ ,Đối tượng khách hàng
		Given Tại màn hình Tạo đơn hàng Tab về Chọn địa chỉ
		When Thay đổi địa chỉ, tỉnh thành
		Then Hệ thông kiểm tra và hiện thị thông tin đã cập nhật địa chỉ
		When Chọn lại đối tượng khách hàng
		Then Hiển thị thông tin đã cập nhật