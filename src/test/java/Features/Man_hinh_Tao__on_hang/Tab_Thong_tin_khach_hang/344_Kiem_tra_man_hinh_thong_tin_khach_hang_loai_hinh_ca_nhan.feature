# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra màn hình thông tin khách hàng loại hình cá nhân

	Scenario: Kiểm tra màn hình thông tin khách hàng loại hình cá nhân
		Given Tại màn hình Tạo đơn hàng
		When Nhấn cập nhật Thông tin khách hàng
		Then Hiển thị màn hình thông tin khách hàng các field về khách hàng cá nhân