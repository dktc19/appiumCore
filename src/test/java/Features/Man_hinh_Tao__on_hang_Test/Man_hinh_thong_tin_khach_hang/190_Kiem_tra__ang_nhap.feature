# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra đăng nhập

	Scenario: Kiểm tra đăng nhập
		Given User mở app
		When Nhập username
		And Nhập password
		And Nhấn nút đăng nhập
		Then Kiểm tra đăng nhập thành công