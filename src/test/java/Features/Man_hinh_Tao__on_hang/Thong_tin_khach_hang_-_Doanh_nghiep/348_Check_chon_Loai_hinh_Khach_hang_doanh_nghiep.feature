# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check chọn Loại hình Khách hàng doanh nghiệp

	Scenario: Check chọn Loại hình Khách hàng doanh nghiệp
		Given Tại màn hình Tạo đơn hàng, Tap Dropdownlist Đối tượng khách hàng
		When Chọn Đối tượng khách hàng là Doanh nghiệp
		When Hiển thị Data được chọn tại Dropdownlist