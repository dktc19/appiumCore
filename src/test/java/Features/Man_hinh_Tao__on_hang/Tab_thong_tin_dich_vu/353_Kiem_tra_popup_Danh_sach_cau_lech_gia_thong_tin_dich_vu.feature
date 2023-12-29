# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra popup Danh sách câu lệch giá thông tin dịch vụ

	Scenario: Kiểm tra popup Danh sách câu lệch giá thông tin dịch vụ
		Given Tại màn hình Tạo đơn hàng
		When Kiểm tra thông tin hiển thị dịch vụ
		Then Hiển thị danh sách thông tin theo block từng dịch vụ
		When Nhấn icon chỉnh sửa tại tiền dịch vụ
		And Kiểm tra popup danh sách câu lệch giá
		Then Hiển thị danh sách câu lệch giá theo chính sách trả ra