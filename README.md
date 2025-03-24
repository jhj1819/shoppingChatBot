## 구현할 기능 정보

### 📦 Product 도메인
- [x] 상품(Product) 엔티티 설계 (id, name, description, price, stock, category, createdAt)
- [x] 상품 등록/조회 API 구현 (POST /api/products, GET /api/products)
- [x] ProductCreateRequest DTO를 사용하여 상품 등록 요청 구조화
- [x] 서비스 레이어, 컨트롤러 레이어, 테스트 코드 작성 (TDD 기반)
- [x] ProductServiceTest, ProductControllerTest 작성 및 통합 테스트 완료

### 📦 Category 도메인
- [x] 카테고리(Category) 엔티티 설계 (id, name, description)
- [x] Product 엔티티와 ManyToOne 관계 매핑 (category_id)
- [x] 상품 등록 시 categoryId를 통해 카테고리 연동

### 📝 API 문서화 및 Swagger 연동
- [x] springdoc-openapi-starter-webmvc-ui 의존성 추가
- [x] Swagger UI 설정 및 `/swagger-ui/index.html`에서 문서 확인 가능
- [x] ProductController에 Swagger @Tag 및 @Operation 어노테이션 추가하여 API 문서 자동화

---

### 🛒 CartItem(장바구니) 도메인
- [ ] 장바구니 엔티티 설계 (user, product, quantity)
- [ ] 장바구니 추가, 삭제, 조회 API
- [ ] CartItemService, CartItemController, DTO 설계 및 TDD 기반 테스트 작성

### 🧾 Order(주문) 도메인
- [ ] 주문(Order), 주문상세(OrderItem) 엔티티 설계
- [ ] 주문 생성 API (장바구니 기반)
- [ ] 주문 내역 조회 API
- [ ] OrderService, OrderController, DTO 설계 및 테스트 작성

### 👤 사용자(User) 및 인증
- [ ] 회원(User) 엔티티 설계 및 회원가입/로그인 API
- [ ] JWT 기반 인증/인가 도입

### 🚨 예외처리 및 표준 응답
- [ ] @ControllerAdvice를 이용한 글로벌 예외 처리
- [ ] API 응답 표준화 (status, message, data 형태로 구조화)
- [ ] 비즈니스 예외에 대한 커스텀 Exception 처리

### 🛠️ 리팩토링
- [ ] DTO → Entity 매핑 로직 분리 (Mapper or Service 내부 정리)
- [ ] 테스트 커버리지 확장 (예외 상황 테스트 포함)
- [ ] 서비스/컨트롤러 리팩토링 및 책임 분리
