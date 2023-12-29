# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra chọn lại Đối tượng khách hàng sale không được phép bán

	Scenario: Kiểm tra chọn lại Đối tượng khách hàng sale không được phép bán
		Given Tại màn hình Tạo đơn hàng click chọn Đối tượng khách hàng
		When Kiểm tra thông tin Đối tượng khách hàng đã chọn
		And Nhấn chọn lại Đối tượng khác hàng khác không được phép bán hàng
		Then Disable Loại hình/ Loại KH không được phép bán