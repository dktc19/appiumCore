# Automation priority: null
# Test case importance: Low
# language: en
Feature: Tạo hợp đồng Internet thành công

	Scenario Outline: Tạo hợp đồng Internet thành công
		Given Login vào tk SPF thành công bằng bằng <Account>và <Password>
		When Nhấn Tất cả dịch vụ tại màn hình trang chủ
		And Nhấn button Bán mới
		And Truy cập màn hình nhập địa chỉ
		And Nhập địa chỉ <DiaChi> muốn tìm kiếm và nhấn tìm kiếm
		And Chọn địa chỉ phù hợp ở list địa chỉ gợi ý
		And Nhấn icon địa chỉ đang được tìm trên map và nhấn xác nhận
		Then Hiển thị màn hình dịch vụ
		When Tại combo tùy chọn nhấn icon Internet
		When Chọn gói dịch vụ <DichVu>, Chọn gói tính cước <GoiTinhCuoc>
		And Nhấn xác nhận
		Then Truy cập màn hình chi tiết
		When Nhấn xác nhận
		And Chờ màn hình tạo đơn hàng tải thành công
		When Nhấn cập nhật thông tin khách hàng
		And Nhập thông tin khách hàng
		And Nhấn xác nhận & lưu
		Then Hiển thị màn hình tạo đơn hàng có thông tin khách hàng đã nhập
		When Chọn phương thức thanh toán tiền mặt
		Then Kiểm tra thông tin dịch vụ Internet
		And Kiểm tra book port
		And Kiểm tra thông tin thanh toán
		When Nhấn button tạo đơn hàng
		Then Tạo đơn hàng thành công và hiển thị màn hình chi tiết đơn hàng
		When Nhấn tạo hợp đồng
		Then Tạo hợp đồng thành công và hiển thị màn hình thanh toán

		@1
		Examples:
		| Account | DiaChi | DichVu | GoiTinhCuoc | Password |
		| "QC.GiangHNL" | "100 Lê Trọng Tấn, phương Tây Thạnh, quận Tân Phú, HCM" | "FTTH - Super100" | "Gói 3T (3T+0)" | "1" |

		@2
		Examples:
		| Account | DiaChi | DichVu | GoiTinhCuoc | Password |
		| "HCM.NhuDTH5" | "300 Nguyễn Thị Thập," | "FTTH - Super80" | "Gói 7T (6T+1)" | "Test123456@" |

		@3
		Examples:
		| Account | DiaChi | DichVu | GoiTinhCuoc | Password |
		| "HCM.NhuDTH5" | "400 Huỳnh Tấn Phát, phường Tân Thuận Đông ,quận 7" | "FTTH - Super150" | "Gói 14T (12T+2)" | "Test123456@" |