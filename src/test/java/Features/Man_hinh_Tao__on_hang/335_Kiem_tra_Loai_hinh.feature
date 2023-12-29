# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra Loại hình

	Scenario: Kiểm tra Loại hình
		Given Tại màn hình Tạo đơn hàng click chọn Đối tượng khách hàng
		When Kiểm tra thông tin Đối tượng khách hàng đã chọn
		And Nhấn chọn lại Đối tượng khác hàng khác không được phép bán hàng
		Then Disable Loại hình/ Loại KH không được phép bán