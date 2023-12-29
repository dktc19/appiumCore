# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check Dropdownlist Đối tượng khách hàng

	Scenario: Check Dropdownlist Đối tượng khách hàng
		When Tap Dropdownlist Đối tượng khách hàng
		And Chọn Đối tượng khách hàng
		Then Đóng popup & tại Dropdownlist hiển thị Đối tượng khách hàng được chọn