# java-spring-boot-challenge

🌟 Dự án: Quản lý công việc cá nhân (Personal Task Manager)


📌 Mô tả:
- Tạo một ứng dụng web đơn giản giúp người dùng quản lý các công việc hàng ngày (tương tự Todo list). Người dùng có thể:
- Thêm công việc mới
- Sửa công việc
- Đánh dấu hoàn thành
- Xóa công việc
- Lọc theo trạng thái (Tất cả / Hoàn thành / Chưa hoàn thành)

⚙️ Công nghệ đề xuất:


- Backend:	Java Spring Boot (REST API)
- Database:	H2 (in-memory) hoặc MySQL/PostgreSQL
- Frontend:	(Tùy chọn) ReactJS, Angular hoặc chỉ Postman để test API
- Build Tool:	Maven hoặc Gradle
- ORM:	Spring Data JPA


Day 1:


🧩 Các chức năng chính (API):


Chức năng:
- GET	/tasks:	Lấy danh sách công việc
- POST /tasks:	Tạo công việc mới
- PUT	/tasks/{id}: Cập nhật công việc
- PATCH	/tasks/{id}/complete:	Đánh dấu hoàn thành
- DELETE	/tasks/{id}:	Xóa công việc

  
📚 Bạn sẽ học được gì?
- Cách tạo project Spring Boot cơ bản
- Cách xây dựng RESTful API
- Cách sử dụng JPA/Hibernate với database
- Cách xử lý các request/response và exception
- (Nếu có frontend) Cách kết nối frontend với backend qua API

Day 2:


🧩 Đăng ký / Đăng nhập người dùng (Authentication)


Học được: Spring Security, JWT, xử lý phân quyền

- Tạo API đăng ký người dùng mới (POST /auth/register)
- API đăng nhập và trả về JWT (POST /auth/login)
- Bảo vệ các API /tasks để chỉ người đã đăng nhập mới sử dụng được
- Chỉ lấy danh sách công việc của user đó thôi

🧩 Tìm kiếm và phân trang


Học được: Spring Data JPA Query, Pageable, Sorting

- API: GET /tasks?keyword=...&status=...&page=0&size=10
- Cho phép tìm theo từ khóa (trong tiêu đề/mô tả)
- Lọc theo trạng thái (ALL / DONE / TODO)
- Thêm phân trang (Pageable)
