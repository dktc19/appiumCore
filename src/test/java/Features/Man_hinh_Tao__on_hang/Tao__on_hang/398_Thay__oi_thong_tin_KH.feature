# Automation priority: null
# Test case importance: Low
# language: en
Feature: Thay đổi thông tin KH

	Scenario: Thay đổi thông tin KH
		Given Tại màn hình Tạo đơn hàng đã nhập thông tin khách hàng
		When Cập nhật thông tin khách hàng
		And Thay đổi thông tin khách hàng
		Then Hiển thị thông tin khách hàng đã thay đổi