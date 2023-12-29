# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra các trường Thông tin thanh toán

	Scenario: Kiểm tra các trường Thông tin thanh toán
		Given Tại màn hình Tạo đơn hàng, Kiểm tra các trường Thông tin thanh toán
		Then Hiển thị các thông tin gồm: - Tổng tiền - Chiết khấu - Voucher -Thành tiền