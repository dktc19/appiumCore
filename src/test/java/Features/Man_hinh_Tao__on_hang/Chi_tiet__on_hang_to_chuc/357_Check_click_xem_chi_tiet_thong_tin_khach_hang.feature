# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check click xem chi tiết thông tin khách hàng

	Scenario: Check click xem chi tiết thông tin khách hàng
		Given Click vào thẻ thông tin KH sau khi cập nhật thông tin KH
		When Check xem chi tiết thông tin khách hàng
		Then Hiển thị đầy đủ thông tin khách hàng người dùng đã nhập. Các thông tin người dùng không nhập sẽ không được hiển thị trên màn hình này.