# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra hiển thị thông tin gói package

	Scenario Outline: Kiểm tra hiển thị thông tin gói package
		When Tại màn hình Thông tin địa chỉ/Tab Tìm kiếm Tap thanh tìm kiếm
		And Nhập địa chỉ <DiaChi> và Tap button Tìm kiếm
		And Chọn địa chỉ <DiaChi> và Tap địa chỉ <DiaChi> trên Tab Tìm kiếm và Tap button Xác nhận
		And Kiểm tra hiển thị thông tin gói package
		Then Hệ thống sẽ hiển thị thông tin package tương ứng với địa chỉ được chọn

		@1
		Examples:
		| DiaChi |
		| "19, Nguyễn Tri Phương, P6, Q5, HCM" |