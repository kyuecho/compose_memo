# 📓 Compose 기반 메모 앱

Jetpack Compose와 Kotlin DSL을 활용해 개발한 메모 애플리케이션입니다.  
MVVM + Clean Architecture 구조로 구성되어 있으며, Room + Flow 기반의 로컬 데이터 처리를 통해 메모의 생성, 수정, 삭제 및 검색 기능을 제공합니다.  
DI는 Hilt를 적용하였으며, 화면 간 이동은 하단 네비게이션 바를 기반으로 구성되어 있습니다.

---

## 🛠️ 기술 스택

| 분야      | 사용 기술                                    |
|-----------|----------------------------------------------|
| UI        | Jetpack Compose, Material3                   |
| 로컬 DB   | Room, Kotlin Flow                            |
| 아키텍처  | MVVM, Clean Architecture                     |
| DI        | Hilt                                         |
| 빌드 시스템 | Kotlin DSL                                 |
| 기타      | Android Navigation Component (Bottom Navigation) |

---

## ✨ 주요 기능

- 메모 작성 / 수정 / 삭제 (CRUD)
- 키워드 기반 메모 검색
- Room + Flow 기반 실시간 데이터 반영
- 하단 네비게이션을 통한 화면 간 전환
- Jetpack Compose 기반의 반응형 UI
- 계층별 분리된 클린 아키텍처 적용
