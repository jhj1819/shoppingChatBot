## 구현할 기능 정보

### 📦 Product 도메인
- [x] 상품(Product) 엔티티 설계 (id, name, description, price, stock, category, createdAt)
- [x] 상품 등록 API (POST /api/products)
- [x] 상품 목록 조회 API (GET /api/products)
- [x] ProductCreateRequest DTO 도입으로 요청 데이터 구조화
- [x] ProductServiceTest, ProductControllerTest 작성 (TDD)

---

### 📦 Category 도메인
- [x] 카테고리(Category) 엔티티 설계 (id, name, description)
- [x] Product 엔티티와 연관관계 (ManyToOne) 매핑
- [x] 상품 등록 시 categoryId를 통해 카테고리 연동

---

### 👤 User(회원) 도메인
- [x] 회원(User) 엔티티 설계 (username, password, email)
- [x] 회원가입 요청 DTO(UserCreateRequest) 작성
- [x] 회원가입 API (POST /api/users/register)
- [x] UserService를 통한 회원 등록 로직 작성
- [x] UserServiceTest로 회원가입 및 DB 저장 검증 테스트

---

### 🛒 CartItem(장바구니) 도메인
- [ ] 장바구니 엔티티 설계 (user, product, quantity)
- [ ] 장바구니 추가 API
- [ ] 장바구니 조회 API
- [ ] 장바구니 삭제 API
- [ ] CartItemService, CartItemController, DTO 설계 및 테스트 작성 예정

---

### 🧾 Order(주문) 도메인
- [ ] 주문(Order) 엔티티 설계 (id, user_id, total_price, status, createdAt)
- [ ] 주문상세(OrderItem) 엔티티 설계 (order_id, product_id, quantity, price)
- [ ] 주문 생성 API (장바구니 기반 주문 생성)
- [ ] 주문 목록 조회 API
- [ ] OrderService, OrderController, DTO 설계 및 테스트 작성 예정

---

### 📝 공통 작업
- [x] Swagger(SpringDoc) 의존성 추가 및 Swagger UI 적용
- [x] Product, User API에 Swagger @Tag, @Operation 문서화 어노테이션 적용
- [ ] API 응답 표준화 (status, message, data 구조로 응답 포맷 작성 예정)
- [ ] 글로벌 예외 처리 핸들러 (@ControllerAdvice 도입 예정)

---

### 🔧 리팩토링
- [ ] DTO → Entity 매핑 로직 분리 (Mapper 패턴 도입 고려)
- [ ] 테스트 커버리지 확장 (실패 케이스 및 예외 테스트 포함)
- [ ] 서비스 및 컨트롤러 책임 분리 및 구조 개선
