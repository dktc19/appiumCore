# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check Sau khi xử lý gạch nợ khoản thu và ghi nhận thanh toán thành công

	Scenario: Check Sau khi xử lý gạch nợ khoản thu và ghi nhận thanh toán thành công
		Given Tại màn hình Thanh toán, Thực hiện thanh toán theo phương thức tiền mặt
		Then Check sau khi xử lý gạch nợ khoản thu và ghi nhận thanh toán thành công