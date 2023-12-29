# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra chọn Phương thưc thanh toán

	Scenario: Kiểm tra chọn Phương thưc thanh toán
		Given Tại màn hình Tạo đơn hàng
		When Kiểm tra giá trị mặc định chọn Phương thưc thanh toán
		Then Phương thưc thanh toán mặc định là Tiền mặt
		When Chọn Phương thưc thanh toán
		Then Cho phép chọn PTTT có trong danh sách trả về. Gía trị được chọn được in đậm và có dấu tích chọn