# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra thoát app tại màn hình Tạo đơn hàng

	Scenario: Kiểm tra thoát app tại màn hình Tạo đơn hàng
		Given Tại màn hình tạo đơn hàng
		When Kill app
		And Mở lại app và kiểm tra danh sách đơn hàng
		Then Hệ thống vẫn lưu lại thông tin đơn hàng trước đó