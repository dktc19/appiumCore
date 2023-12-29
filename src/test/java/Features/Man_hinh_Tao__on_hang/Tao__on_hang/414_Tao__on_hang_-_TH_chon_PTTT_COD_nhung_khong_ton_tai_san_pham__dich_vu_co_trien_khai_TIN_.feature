# Automation priority: null
# Test case importance: Low
# language: en
Feature: Tạo đơn hàng - TH chọn PTTT COD nhưng không tồn tại sản phẩm/ dịch vụ có triển khai TIN/PNC

	Scenario Outline: Tạo đơn hàng - TH chọn PTTT COD nhưng không tồn tại sản phẩm/ dịch vụ có triển khai TIN/PNC
		Given Login vào tk SPF thành công bằng <Account> và <Password>
		When Truy cập màn hình Dịch vụ từ màn hình Menu
		And Nhập địa chỉ khách hàng
		And Chọn dịch vụ không triển khai TIN/PNC
		And Di chuyển đến màn hình Tạo đơn hàng
		And Chọn phương thức thanh toán COD
		And Nhấn button Tạo đơn hàng
		Then Hiển thị message: 'Đơn hàng phải tồn tại dịch vụ/sản phẩm có triển khai và không có các hình thức triển khai là sale giao hoặc đối tác giao hàng thì được phép sử dụng phương thức thanh toán COD.'

		@1
		Examples:
		| Account | Password |
		| "HCM.VanMTT3" | "Test123456@" |