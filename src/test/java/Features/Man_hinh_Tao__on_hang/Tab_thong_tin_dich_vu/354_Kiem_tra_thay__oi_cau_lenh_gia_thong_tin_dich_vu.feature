# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra thay đổi câu lệnh giá thông tin dịch vụ

	Scenario: Kiểm tra thay đổi câu lệnh giá thông tin dịch vụ
		Given Tại màn hình Tạo đơn hàng
		When Kiểm tra thông tin hiển thị dịch vụ
		Then Hiển thị danh sách thông tin theo block từng dịch vụ
		When Nhấn icon chỉnh sửa tại tiền dịch vụ
		And Kiểm tra popup danh sách câu lệch giá
		Then Hiển thị danh sách câu lệch giá theo chính sách trả ra
		When Chọn câu lệnh giá
		Then Hiển thị câu lệnh giá đã chọn với text ' Cập nhật giá'