# Automation priority: null
# Test case importance: Low
# language: en
Feature: Tại màn hình Tạo đơn hàng tab về tab chọn địa chỉ

	Scenario: Tại màn hình Tạo đơn hàng tab về tab chọn địa chỉ
		Given Tại màn hình Tạo đơn hàng Tab về Chọn địa chỉ
		When Không thay đổi địa chỉ nhấn quay lại màn hinh Tạo đơn hàng
		Then App vẫn giữ nguyên thông tin Màn hình Tạo đơn hàng