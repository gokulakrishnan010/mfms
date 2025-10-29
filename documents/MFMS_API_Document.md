# MFMS API Documentation

**Generated from source code (best-effort static scan). Please verify details in controllers.**

## Overview
- **Service**: Mutual Fund Management System (MFMS)
- **Base URL**: `{BASE_URL}` (e.g., `http://localhost:8080` or gateway)
- **Auth**: Spring Security (details not inferred)

## Conventions
- Request/response bodies are JSON unless otherwise noted.
- Timestamps in ISO‑8601.
- Errors follow a standardized `ApiError` body (verify in `exceptions`).

### com.acme.mutualfund.auth.AdminController

- Base path: `/api/v1/admin`

**DELETE /api/v1/admin**  

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `username`: *@PathVariable String*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AdminController.java`

- Example:

```bash
curl -X DELETE "{{BASE_URL}}/api/v1/admin" -H "Content-Type: application/json"
```

**DELETE /api/v1/admin**  

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `username`: *@PathVariable String*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AdminController.java`

- Example:

```bash
curl -X DELETE "{{BASE_URL}}/api/v1/admin" -H "Content-Type: application/json"
```

**DELETE /api/v1/admin**  

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `username`: *@PathVariable String*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AdminController.java`

- Example:

```bash
curl -X DELETE "{{BASE_URL}}/api/v1/admin" -H "Content-Type: application/json"
```

**DELETE /api/v1/admin**  

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `username`: *@PathVariable String*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AdminController.java`

- Example:

```bash
curl -X DELETE "{{BASE_URL}}/api/v1/admin" -H "Content-Type: application/json"
```

**DELETE /api/v1/admin**  

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `username`: *@PathVariable String*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AdminController.java`

- Example:

```bash
curl -X DELETE "{{BASE_URL}}/api/v1/admin" -H "Content-Type: application/json"
```

**GET /api/v1/admin**  

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AdminController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/admin" -H "Content-Type: application/json"
```

**GET /api/v1/admin**  

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AdminController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/admin" -H "Content-Type: application/json"
```

**GET /api/v1/admin**  

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AdminController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/admin" -H "Content-Type: application/json"
```

**GET /api/v1/admin**  

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AdminController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/admin" -H "Content-Type: application/json"
```

**GET /api/v1/admin**  

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AdminController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/admin" -H "Content-Type: application/json"
```



### com.acme.mutualfund.auth.AccountController

- Base path: `/api/v1/auth`

**GET /api/v1/auth/value**  

- Produces: `application/json`

- Params:

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AccountController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/auth/value" -H "Content-Type: application/json"
```

**GET /api/v1/auth/value**  

- Produces: `application/json`

- Params:

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AccountController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/auth/value" -H "Content-Type: application/json"
```

**GET /api/v1/auth/value**  

- Produces: `application/json`

- Params:

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AccountController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/auth/value" -H "Content-Type: application/json"
```

**GET /api/v1/auth/value**  

- Produces: `application/json`

- Params:

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AccountController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/auth/value" -H "Content-Type: application/json"
```

**GET /api/v1/auth/value**  

- Produces: `application/json`

- Params:

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AccountController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/auth/value" -H "Content-Type: application/json"
```

**POST /api/v1/auth/value**  

- Consumes: `application/json`

- Params:

  - `req`: *@Valid @RequestBody EnrollReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AccountController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/auth/value" -H "Content-Type: application/json"
```

**POST /api/v1/auth/value**  

- Consumes: `application/json`

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody EnrollReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AccountController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/auth/value" -H "Content-Type: application/json"
```

**POST /api/v1/auth/value**  

- Consumes: `application/json`

- Params:

  - `req`: *@Valid @RequestBody EnrollReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AccountController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/auth/value" -H "Content-Type: application/json"
```

**POST /api/v1/auth/value**  

- Consumes: `application/json`

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody EnrollReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AccountController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/auth/value" -H "Content-Type: application/json"
```

**POST /api/v1/auth/value**  

- Consumes: `application/json`

- Params:

  - `req`: *@Valid @RequestBody EnrollReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AccountController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/auth/value" -H "Content-Type: application/json"
```

**POST /api/v1/auth/value**  

- Consumes: `application/json`

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody EnrollReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AccountController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/auth/value" -H "Content-Type: application/json"
```

**POST /api/v1/auth/value**  

- Consumes: `application/json`

- Params:

  - `req`: *@Valid @RequestBody EnrollReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AccountController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/auth/value" -H "Content-Type: application/json"
```

**POST /api/v1/auth/value**  

- Consumes: `application/json`

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody EnrollReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AccountController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/auth/value" -H "Content-Type: application/json"
```

**POST /api/v1/auth/value**  

- Consumes: `application/json`

- Params:

  - `req`: *@Valid @RequestBody EnrollReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AccountController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/auth/value" -H "Content-Type: application/json"
```

**POST /api/v1/auth/value**  

- Consumes: `application/json`

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody EnrollReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/auth/AccountController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/auth/value" -H "Content-Type: application/json"
```



### com.acme.mutualfund.controller.HelloController

**GET /**  

- Source: `mfms/src/main/java/com/acme/mutualfund/controller/HelloController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}" -H "Content-Type: application/json"
```

**GET /**  

- Source: `mfms/src/main/java/com/acme/mutualfund/controller/HelloController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}" -H "Content-Type: application/json"
```

**GET /**  

- Source: `mfms/src/main/java/com/acme/mutualfund/controller/HelloController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}" -H "Content-Type: application/json"
```

**GET /**  

- Source: `mfms/src/main/java/com/acme/mutualfund/controller/HelloController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}" -H "Content-Type: application/json"
```

**GET /**  

- Source: `mfms/src/main/java/com/acme/mutualfund/controller/HelloController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}" -H "Content-Type: application/json"
```



### com.acme.mutualfund.portfolio.PortfolioController

- Base path: `/api/v1/portfolio`

**GET /api/v1/portfolio**  

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('USER') or hasRole('ADMIN'))`

- Params:

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/portfolio/PortfolioController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/portfolio" -H "Content-Type: application/json"
```

**GET /api/v1/portfolio**  

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('USER') or hasRole('ADMIN'))`

- Params:

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/portfolio/PortfolioController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/portfolio" -H "Content-Type: application/json"
```

**GET /api/v1/portfolio**  

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('USER') or hasRole('ADMIN'))`

- Params:

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/portfolio/PortfolioController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/portfolio" -H "Content-Type: application/json"
```

**GET /api/v1/portfolio**  

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('USER') or hasRole('ADMIN'))`

- Params:

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/portfolio/PortfolioController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/portfolio" -H "Content-Type: application/json"
```

**GET /api/v1/portfolio**  

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('USER') or hasRole('ADMIN'))`

- Params:

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/portfolio/PortfolioController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/portfolio" -H "Content-Type: application/json"
```

**POST /api/v1/portfolio/value**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('USER') or hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody TradeReq*

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/portfolio/PortfolioController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/portfolio/value" -H "Content-Type: application/json"
```

**POST /api/v1/portfolio/value**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('USER') or hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody TradeReq*

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/portfolio/PortfolioController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/portfolio/value" -H "Content-Type: application/json"
```

**POST /api/v1/portfolio/value**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('USER') or hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody TradeReq*

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/portfolio/PortfolioController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/portfolio/value" -H "Content-Type: application/json"
```

**POST /api/v1/portfolio/value**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('USER') or hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody TradeReq*

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/portfolio/PortfolioController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/portfolio/value" -H "Content-Type: application/json"
```

**POST /api/v1/portfolio/value**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('USER') or hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody TradeReq*

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/portfolio/PortfolioController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/portfolio/value" -H "Content-Type: application/json"
```

**POST /api/v1/portfolio/value**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('USER') or hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody TradeReq*

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/portfolio/PortfolioController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/portfolio/value" -H "Content-Type: application/json"
```

**POST /api/v1/portfolio/value**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('USER') or hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody TradeReq*

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/portfolio/PortfolioController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/portfolio/value" -H "Content-Type: application/json"
```

**POST /api/v1/portfolio/value**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('USER') or hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody TradeReq*

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/portfolio/PortfolioController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/portfolio/value" -H "Content-Type: application/json"
```

**POST /api/v1/portfolio/value**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('USER') or hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody TradeReq*

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/portfolio/PortfolioController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/portfolio/value" -H "Content-Type: application/json"
```

**POST /api/v1/portfolio/value**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('USER') or hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody TradeReq*

  - `auth`: *Authentication*

- Source: `mfms/src/main/java/com/acme/mutualfund/portfolio/PortfolioController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/portfolio/value" -H "Content-Type: application/json"
```



### com.acme.mutualfund.fund.FundController

- Base path: `/api/v1/funds`

**GET /api/v1/funds**  

- Produces: `application/json`

- Source: `mfms/src/main/java/com/acme/mutualfund/fund/FundController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/funds" -H "Content-Type: application/json"
```

**GET /api/v1/funds**  

- Produces: `application/json`

- Source: `mfms/src/main/java/com/acme/mutualfund/fund/FundController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/funds" -H "Content-Type: application/json"
```

**GET /api/v1/funds**  

- Produces: `application/json`

- Source: `mfms/src/main/java/com/acme/mutualfund/fund/FundController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/funds" -H "Content-Type: application/json"
```

**GET /api/v1/funds**  

- Produces: `application/json`

- Source: `mfms/src/main/java/com/acme/mutualfund/fund/FundController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/funds" -H "Content-Type: application/json"
```

**GET /api/v1/funds**  

- Produces: `application/json`

- Source: `mfms/src/main/java/com/acme/mutualfund/fund/FundController.java`

- Example:

```bash
curl -X GET "{{BASE_URL}}/api/v1/funds" -H "Content-Type: application/json"
```

**POST /api/v1/funds**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody CreateFundReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/fund/FundController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/funds" -H "Content-Type: application/json"
```

**POST /api/v1/funds**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody CreateFundReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/fund/FundController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/funds" -H "Content-Type: application/json"
```

**POST /api/v1/funds**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody CreateFundReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/fund/FundController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/funds" -H "Content-Type: application/json"
```

**POST /api/v1/funds**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody CreateFundReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/fund/FundController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/funds" -H "Content-Type: application/json"
```

**POST /api/v1/funds**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `req`: *@Valid @RequestBody CreateFundReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/fund/FundController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/funds" -H "Content-Type: application/json"
```

**POST /api/v1/funds/value**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `symbol`: *@PathVariable String*

  - `req`: *@Valid @RequestBody NavReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/fund/FundController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/funds/value" -H "Content-Type: application/json"
```

**POST /api/v1/funds/value**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `symbol`: *@PathVariable String*

  - `req`: *@Valid @RequestBody NavReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/fund/FundController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/funds/value" -H "Content-Type: application/json"
```

**POST /api/v1/funds/value**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `symbol`: *@PathVariable String*

  - `req`: *@Valid @RequestBody NavReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/fund/FundController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/funds/value" -H "Content-Type: application/json"
```

**POST /api/v1/funds/value**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `symbol`: *@PathVariable String*

  - `req`: *@Valid @RequestBody NavReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/fund/FundController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/funds/value" -H "Content-Type: application/json"
```

**POST /api/v1/funds/value**  

- Consumes: `application/json, produces = "application/json`

- Produces: `application/json`

- Security: `@PreAuthorize(hasRole('ADMIN'))`

- Params:

  - `symbol`: *@PathVariable String*

  - `req`: *@Valid @RequestBody NavReq*

- Source: `mfms/src/main/java/com/acme/mutualfund/fund/FundController.java`

- Example:

```bash
curl -X POST "{{BASE_URL}}/api/v1/funds/value" -H "Content-Type: application/json"
```



## DTOs (Detected)

**TradeReq** (record)  

- Fields:

  - `@NotBlank
        @Schema(
                description = "Symbol of the mutual fund to trade."`: *unknown*

  - `example = "ALPHA"
        )
        String symbol`: *unknown*

  - `@NotNull
        @DecimalMin(value = "0.0"`: *unknown*

  - `inclusive = false)
        @Schema(
                description = "Number of fund units to buy or redeem. Must be greater than 0."`: *unknown*

  - `example = "10.00000000"
        )
        BigDecimal units`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/TradeReq.java`


**NavDto** (record)  

- Fields:

  - `@Schema(description = "Unique symbol of the mutual fund."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Date for which the NAV is applicable."`: *unknown*

  - `example = "2025-10-28"`: *unknown*

  - `format = "date")
        LocalDate date`: *unknown*

  - `@Schema(description = "Net Asset Value (NAV) per unit for the given date."`: *unknown*

  - `example = "51.245600")
        BigDecimal nav`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/NavDto.java`


**PortfolioDto** (record)  

- Fields:

  - `@ArraySchema(
                schema = @Schema(implementation = HoldingDto.class)`: *unknown*

  - `arraySchema = @Schema(
                        description = "List of holdings in the user's portfolio`: *unknown*

  - `including`: *each*

  - `units`: *unknown*

  - `NAV`: *unknown*

  - `value`: *and*

  - `@Schema(
                description = "Total current value of all holdings based on today's NAV."`: *unknown*

  - `example = "625.000000"
        )
        BigDecimal totalValueToday`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/PortfolioDto.java`


**CreateFundReq** (record)  

- Fields:

  - `@NotBlank
        @Pattern(regexp = "^[A-Z]{3`: *unknown*

  - `10}$")
        @Schema(description = "Unique symbol identifier for the mutual fund (ticker-like`: *unknown*

  - `3–10 uppercase letters)."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@NotBlank
        @Schema(description = "Human-readable name of the mutual fund."`: *unknown*

  - `example = "Alpha Growth Fund")
        String name`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/CreateFundReq.java`


**EnrollReq** (record)  

- Fields:

  - `@NotBlank
        @Schema(description = "Unique username for the new account."`: *unknown*

  - `example = "user1")
        String username`: *unknown*

  - `@NotBlank
        @Size(min = 8`: *unknown*

  - `max = 120)
        @Schema(description = "User password (minimum 8 characters)."`: *unknown*

  - `example = "s3cretP@ss")
        String password`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/EnrollReq.java`


**TradeDto** (record)  

- Fields:

  - `@Schema(description = "Unique identifier of the trade transaction."`: *unknown*

  - `example = "1001"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        Long id`: *unknown*

  - `@Schema(description = "Type of trade operation — BUY or REDEEM."`: *unknown*

  - `example = "BUY")
        TransactionType type`: *unknown*

  - `// enum below

        @Schema(description = "Symbol of the mutual fund involved in the trade."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Number of units bought or redeemed."`: *unknown*

  - `example = "10.00000000")
        BigDecimal units`: *unknown*

  - `@Schema(description = "Net Asset Value (NAV) per unit used for the trade."`: *unknown*

  - `example = "51.245600"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal nav`: *unknown*

  - `@Schema(description = "Total trade amount = units × NAV."`: *unknown*

  - `example = "512.456000"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal amount`: *unknown*

  - `@Schema(description = "Timestamp when the trade was executed."`: *unknown*

  - `example = "2025-10-28T14:32:55Z"`: *unknown*

  - `format = "date-time"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        Instant ts`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/TradeDto.java`


**HoldingDto** (record)  

- Fields:

  - `@Schema(description = "Symbol of the mutual fund."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Number of units currently held."`: *unknown*

  - `example = "12.50000000")
        BigDecimal units`: *unknown*

  - `@Schema(description = "Today's Net Asset Value (NAV) per unit for this fund."`: *unknown*

  - `example = "50.000000"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal todayNav`: *unknown*

  - `@Schema(description = "Total value of this holding = units × today's NAV."`: *unknown*

  - `example = "625.000000"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal valueToday`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/HoldingDto.java`


**NavReq** (record)  

- Fields:

  - `@NotNull
        @DecimalMin(value = "0.0001"`: *unknown*

  - `inclusive = false)
        @Schema(
                description = "Today's Net Asset Value (NAV) per unit. Must be greater than 0.0001."`: *unknown*

  - `example = "51.245600"
        )
        BigDecimal nav`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/NavReq.java`


**FundDto** (record)  

- Fields:

  - `@Schema(description = "Unique fund symbol identifier (ticker-like)."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Display name of the mutual fund."`: *unknown*

  - `example = "Alpha Growth Fund")
        String name`: *unknown*

  - `@Schema(description = "Today's Net Asset Value (NAV) per unit."`: *unknown*

  - `example = "51.245600"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal todayNav`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/FundDto.java`


**PrincipalDto** (record)  

- Fields:

  - `@Schema(example = "gokul") String username`: *unknown*

  - `@Schema(description = "Granted authorities") List<String> roles`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/PrincipalDto.java`


**TradeReq** (record)  

- Fields:

  - `@NotBlank
        @Schema(
                description = "Symbol of the mutual fund to trade."`: *unknown*

  - `example = "ALPHA"
        )
        String symbol`: *unknown*

  - `@NotNull
        @DecimalMin(value = "0.0"`: *unknown*

  - `inclusive = false)
        @Schema(
                description = "Number of fund units to buy or redeem. Must be greater than 0."`: *unknown*

  - `example = "10.00000000"
        )
        BigDecimal units`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/TradeReq.java`


**NavDto** (record)  

- Fields:

  - `@Schema(description = "Unique symbol of the mutual fund."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Date for which the NAV is applicable."`: *unknown*

  - `example = "2025-10-28"`: *unknown*

  - `format = "date")
        LocalDate date`: *unknown*

  - `@Schema(description = "Net Asset Value (NAV) per unit for the given date."`: *unknown*

  - `example = "51.245600")
        BigDecimal nav`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/NavDto.java`


**PortfolioDto** (record)  

- Fields:

  - `@ArraySchema(
                schema = @Schema(implementation = HoldingDto.class)`: *unknown*

  - `arraySchema = @Schema(
                        description = "List of holdings in the user's portfolio`: *unknown*

  - `including`: *each*

  - `units`: *unknown*

  - `NAV`: *unknown*

  - `value`: *and*

  - `@Schema(
                description = "Total current value of all holdings based on today's NAV."`: *unknown*

  - `example = "625.000000"
        )
        BigDecimal totalValueToday`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/PortfolioDto.java`


**CreateFundReq** (record)  

- Fields:

  - `@NotBlank
        @Pattern(regexp = "^[A-Z]{3`: *unknown*

  - `10}$")
        @Schema(description = "Unique symbol identifier for the mutual fund (ticker-like`: *unknown*

  - `3–10 uppercase letters)."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@NotBlank
        @Schema(description = "Human-readable name of the mutual fund."`: *unknown*

  - `example = "Alpha Growth Fund")
        String name`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/CreateFundReq.java`


**EnrollReq** (record)  

- Fields:

  - `@NotBlank
        @Schema(description = "Unique username for the new account."`: *unknown*

  - `example = "user1")
        String username`: *unknown*

  - `@NotBlank
        @Size(min = 8`: *unknown*

  - `max = 120)
        @Schema(description = "User password (minimum 8 characters)."`: *unknown*

  - `example = "s3cretP@ss")
        String password`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/EnrollReq.java`


**TradeDto** (record)  

- Fields:

  - `@Schema(description = "Unique identifier of the trade transaction."`: *unknown*

  - `example = "1001"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        Long id`: *unknown*

  - `@Schema(description = "Type of trade operation — BUY or REDEEM."`: *unknown*

  - `example = "BUY")
        TransactionType type`: *unknown*

  - `// enum below

        @Schema(description = "Symbol of the mutual fund involved in the trade."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Number of units bought or redeemed."`: *unknown*

  - `example = "10.00000000")
        BigDecimal units`: *unknown*

  - `@Schema(description = "Net Asset Value (NAV) per unit used for the trade."`: *unknown*

  - `example = "51.245600"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal nav`: *unknown*

  - `@Schema(description = "Total trade amount = units × NAV."`: *unknown*

  - `example = "512.456000"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal amount`: *unknown*

  - `@Schema(description = "Timestamp when the trade was executed."`: *unknown*

  - `example = "2025-10-28T14:32:55Z"`: *unknown*

  - `format = "date-time"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        Instant ts`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/TradeDto.java`


**HoldingDto** (record)  

- Fields:

  - `@Schema(description = "Symbol of the mutual fund."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Number of units currently held."`: *unknown*

  - `example = "12.50000000")
        BigDecimal units`: *unknown*

  - `@Schema(description = "Today's Net Asset Value (NAV) per unit for this fund."`: *unknown*

  - `example = "50.000000"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal todayNav`: *unknown*

  - `@Schema(description = "Total value of this holding = units × today's NAV."`: *unknown*

  - `example = "625.000000"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal valueToday`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/HoldingDto.java`


**NavReq** (record)  

- Fields:

  - `@NotNull
        @DecimalMin(value = "0.0001"`: *unknown*

  - `inclusive = false)
        @Schema(
                description = "Today's Net Asset Value (NAV) per unit. Must be greater than 0.0001."`: *unknown*

  - `example = "51.245600"
        )
        BigDecimal nav`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/NavReq.java`


**FundDto** (record)  

- Fields:

  - `@Schema(description = "Unique fund symbol identifier (ticker-like)."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Display name of the mutual fund."`: *unknown*

  - `example = "Alpha Growth Fund")
        String name`: *unknown*

  - `@Schema(description = "Today's Net Asset Value (NAV) per unit."`: *unknown*

  - `example = "51.245600"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal todayNav`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/FundDto.java`


**PrincipalDto** (record)  

- Fields:

  - `@Schema(example = "gokul") String username`: *unknown*

  - `@Schema(description = "Granted authorities") List<String> roles`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/PrincipalDto.java`


**TradeReq** (record)  

- Fields:

  - `@NotBlank
        @Schema(
                description = "Symbol of the mutual fund to trade."`: *unknown*

  - `example = "ALPHA"
        )
        String symbol`: *unknown*

  - `@NotNull
        @DecimalMin(value = "0.0"`: *unknown*

  - `inclusive = false)
        @Schema(
                description = "Number of fund units to buy or redeem. Must be greater than 0."`: *unknown*

  - `example = "10.00000000"
        )
        BigDecimal units`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/TradeReq.java`


**NavDto** (record)  

- Fields:

  - `@Schema(description = "Unique symbol of the mutual fund."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Date for which the NAV is applicable."`: *unknown*

  - `example = "2025-10-28"`: *unknown*

  - `format = "date")
        LocalDate date`: *unknown*

  - `@Schema(description = "Net Asset Value (NAV) per unit for the given date."`: *unknown*

  - `example = "51.245600")
        BigDecimal nav`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/NavDto.java`


**PortfolioDto** (record)  

- Fields:

  - `@ArraySchema(
                schema = @Schema(implementation = HoldingDto.class)`: *unknown*

  - `arraySchema = @Schema(
                        description = "List of holdings in the user's portfolio`: *unknown*

  - `including`: *each*

  - `units`: *unknown*

  - `NAV`: *unknown*

  - `value`: *and*

  - `@Schema(
                description = "Total current value of all holdings based on today's NAV."`: *unknown*

  - `example = "625.000000"
        )
        BigDecimal totalValueToday`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/PortfolioDto.java`


**CreateFundReq** (record)  

- Fields:

  - `@NotBlank
        @Pattern(regexp = "^[A-Z]{3`: *unknown*

  - `10}$")
        @Schema(description = "Unique symbol identifier for the mutual fund (ticker-like`: *unknown*

  - `3–10 uppercase letters)."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@NotBlank
        @Schema(description = "Human-readable name of the mutual fund."`: *unknown*

  - `example = "Alpha Growth Fund")
        String name`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/CreateFundReq.java`


**EnrollReq** (record)  

- Fields:

  - `@NotBlank
        @Schema(description = "Unique username for the new account."`: *unknown*

  - `example = "user1")
        String username`: *unknown*

  - `@NotBlank
        @Size(min = 8`: *unknown*

  - `max = 120)
        @Schema(description = "User password (minimum 8 characters)."`: *unknown*

  - `example = "s3cretP@ss")
        String password`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/EnrollReq.java`


**TradeDto** (record)  

- Fields:

  - `@Schema(description = "Unique identifier of the trade transaction."`: *unknown*

  - `example = "1001"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        Long id`: *unknown*

  - `@Schema(description = "Type of trade operation — BUY or REDEEM."`: *unknown*

  - `example = "BUY")
        TransactionType type`: *unknown*

  - `// enum below

        @Schema(description = "Symbol of the mutual fund involved in the trade."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Number of units bought or redeemed."`: *unknown*

  - `example = "10.00000000")
        BigDecimal units`: *unknown*

  - `@Schema(description = "Net Asset Value (NAV) per unit used for the trade."`: *unknown*

  - `example = "51.245600"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal nav`: *unknown*

  - `@Schema(description = "Total trade amount = units × NAV."`: *unknown*

  - `example = "512.456000"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal amount`: *unknown*

  - `@Schema(description = "Timestamp when the trade was executed."`: *unknown*

  - `example = "2025-10-28T14:32:55Z"`: *unknown*

  - `format = "date-time"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        Instant ts`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/TradeDto.java`


**HoldingDto** (record)  

- Fields:

  - `@Schema(description = "Symbol of the mutual fund."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Number of units currently held."`: *unknown*

  - `example = "12.50000000")
        BigDecimal units`: *unknown*

  - `@Schema(description = "Today's Net Asset Value (NAV) per unit for this fund."`: *unknown*

  - `example = "50.000000"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal todayNav`: *unknown*

  - `@Schema(description = "Total value of this holding = units × today's NAV."`: *unknown*

  - `example = "625.000000"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal valueToday`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/HoldingDto.java`


**NavReq** (record)  

- Fields:

  - `@NotNull
        @DecimalMin(value = "0.0001"`: *unknown*

  - `inclusive = false)
        @Schema(
                description = "Today's Net Asset Value (NAV) per unit. Must be greater than 0.0001."`: *unknown*

  - `example = "51.245600"
        )
        BigDecimal nav`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/NavReq.java`


**FundDto** (record)  

- Fields:

  - `@Schema(description = "Unique fund symbol identifier (ticker-like)."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Display name of the mutual fund."`: *unknown*

  - `example = "Alpha Growth Fund")
        String name`: *unknown*

  - `@Schema(description = "Today's Net Asset Value (NAV) per unit."`: *unknown*

  - `example = "51.245600"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal todayNav`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/FundDto.java`


**PrincipalDto** (record)  

- Fields:

  - `@Schema(example = "gokul") String username`: *unknown*

  - `@Schema(description = "Granted authorities") List<String> roles`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/PrincipalDto.java`


**TradeReq** (record)  

- Fields:

  - `@NotBlank
        @Schema(
                description = "Symbol of the mutual fund to trade."`: *unknown*

  - `example = "ALPHA"
        )
        String symbol`: *unknown*

  - `@NotNull
        @DecimalMin(value = "0.0"`: *unknown*

  - `inclusive = false)
        @Schema(
                description = "Number of fund units to buy or redeem. Must be greater than 0."`: *unknown*

  - `example = "10.00000000"
        )
        BigDecimal units`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/TradeReq.java`


**NavDto** (record)  

- Fields:

  - `@Schema(description = "Unique symbol of the mutual fund."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Date for which the NAV is applicable."`: *unknown*

  - `example = "2025-10-28"`: *unknown*

  - `format = "date")
        LocalDate date`: *unknown*

  - `@Schema(description = "Net Asset Value (NAV) per unit for the given date."`: *unknown*

  - `example = "51.245600")
        BigDecimal nav`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/NavDto.java`


**PortfolioDto** (record)  

- Fields:

  - `@ArraySchema(
                schema = @Schema(implementation = HoldingDto.class)`: *unknown*

  - `arraySchema = @Schema(
                        description = "List of holdings in the user's portfolio`: *unknown*

  - `including`: *each*

  - `units`: *unknown*

  - `NAV`: *unknown*

  - `value`: *and*

  - `@Schema(
                description = "Total current value of all holdings based on today's NAV."`: *unknown*

  - `example = "625.000000"
        )
        BigDecimal totalValueToday`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/PortfolioDto.java`


**CreateFundReq** (record)  

- Fields:

  - `@NotBlank
        @Pattern(regexp = "^[A-Z]{3`: *unknown*

  - `10}$")
        @Schema(description = "Unique symbol identifier for the mutual fund (ticker-like`: *unknown*

  - `3–10 uppercase letters)."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@NotBlank
        @Schema(description = "Human-readable name of the mutual fund."`: *unknown*

  - `example = "Alpha Growth Fund")
        String name`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/CreateFundReq.java`


**EnrollReq** (record)  

- Fields:

  - `@NotBlank
        @Schema(description = "Unique username for the new account."`: *unknown*

  - `example = "user1")
        String username`: *unknown*

  - `@NotBlank
        @Size(min = 8`: *unknown*

  - `max = 120)
        @Schema(description = "User password (minimum 8 characters)."`: *unknown*

  - `example = "s3cretP@ss")
        String password`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/EnrollReq.java`


**TradeDto** (record)  

- Fields:

  - `@Schema(description = "Unique identifier of the trade transaction."`: *unknown*

  - `example = "1001"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        Long id`: *unknown*

  - `@Schema(description = "Type of trade operation — BUY or REDEEM."`: *unknown*

  - `example = "BUY")
        TransactionType type`: *unknown*

  - `// enum below

        @Schema(description = "Symbol of the mutual fund involved in the trade."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Number of units bought or redeemed."`: *unknown*

  - `example = "10.00000000")
        BigDecimal units`: *unknown*

  - `@Schema(description = "Net Asset Value (NAV) per unit used for the trade."`: *unknown*

  - `example = "51.245600"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal nav`: *unknown*

  - `@Schema(description = "Total trade amount = units × NAV."`: *unknown*

  - `example = "512.456000"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal amount`: *unknown*

  - `@Schema(description = "Timestamp when the trade was executed."`: *unknown*

  - `example = "2025-10-28T14:32:55Z"`: *unknown*

  - `format = "date-time"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        Instant ts`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/TradeDto.java`


**HoldingDto** (record)  

- Fields:

  - `@Schema(description = "Symbol of the mutual fund."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Number of units currently held."`: *unknown*

  - `example = "12.50000000")
        BigDecimal units`: *unknown*

  - `@Schema(description = "Today's Net Asset Value (NAV) per unit for this fund."`: *unknown*

  - `example = "50.000000"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal todayNav`: *unknown*

  - `@Schema(description = "Total value of this holding = units × today's NAV."`: *unknown*

  - `example = "625.000000"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal valueToday`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/HoldingDto.java`


**NavReq** (record)  

- Fields:

  - `@NotNull
        @DecimalMin(value = "0.0001"`: *unknown*

  - `inclusive = false)
        @Schema(
                description = "Today's Net Asset Value (NAV) per unit. Must be greater than 0.0001."`: *unknown*

  - `example = "51.245600"
        )
        BigDecimal nav`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/NavReq.java`


**FundDto** (record)  

- Fields:

  - `@Schema(description = "Unique fund symbol identifier (ticker-like)."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Display name of the mutual fund."`: *unknown*

  - `example = "Alpha Growth Fund")
        String name`: *unknown*

  - `@Schema(description = "Today's Net Asset Value (NAV) per unit."`: *unknown*

  - `example = "51.245600"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal todayNav`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/FundDto.java`


**PrincipalDto** (record)  

- Fields:

  - `@Schema(example = "gokul") String username`: *unknown*

  - `@Schema(description = "Granted authorities") List<String> roles`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/PrincipalDto.java`


**TradeReq** (record)  

- Fields:

  - `@NotBlank
        @Schema(
                description = "Symbol of the mutual fund to trade."`: *unknown*

  - `example = "ALPHA"
        )
        String symbol`: *unknown*

  - `@NotNull
        @DecimalMin(value = "0.0"`: *unknown*

  - `inclusive = false)
        @Schema(
                description = "Number of fund units to buy or redeem. Must be greater than 0."`: *unknown*

  - `example = "10.00000000"
        )
        BigDecimal units`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/TradeReq.java`


**NavDto** (record)  

- Fields:

  - `@Schema(description = "Unique symbol of the mutual fund."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Date for which the NAV is applicable."`: *unknown*

  - `example = "2025-10-28"`: *unknown*

  - `format = "date")
        LocalDate date`: *unknown*

  - `@Schema(description = "Net Asset Value (NAV) per unit for the given date."`: *unknown*

  - `example = "51.245600")
        BigDecimal nav`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/NavDto.java`


**PortfolioDto** (record)  

- Fields:

  - `@ArraySchema(
                schema = @Schema(implementation = HoldingDto.class)`: *unknown*

  - `arraySchema = @Schema(
                        description = "List of holdings in the user's portfolio`: *unknown*

  - `including`: *each*

  - `units`: *unknown*

  - `NAV`: *unknown*

  - `value`: *and*

  - `@Schema(
                description = "Total current value of all holdings based on today's NAV."`: *unknown*

  - `example = "625.000000"
        )
        BigDecimal totalValueToday`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/PortfolioDto.java`


**CreateFundReq** (record)  

- Fields:

  - `@NotBlank
        @Pattern(regexp = "^[A-Z]{3`: *unknown*

  - `10}$")
        @Schema(description = "Unique symbol identifier for the mutual fund (ticker-like`: *unknown*

  - `3–10 uppercase letters)."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@NotBlank
        @Schema(description = "Human-readable name of the mutual fund."`: *unknown*

  - `example = "Alpha Growth Fund")
        String name`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/CreateFundReq.java`


**EnrollReq** (record)  

- Fields:

  - `@NotBlank
        @Schema(description = "Unique username for the new account."`: *unknown*

  - `example = "user1")
        String username`: *unknown*

  - `@NotBlank
        @Size(min = 8`: *unknown*

  - `max = 120)
        @Schema(description = "User password (minimum 8 characters)."`: *unknown*

  - `example = "s3cretP@ss")
        String password`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/EnrollReq.java`


**TradeDto** (record)  

- Fields:

  - `@Schema(description = "Unique identifier of the trade transaction."`: *unknown*

  - `example = "1001"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        Long id`: *unknown*

  - `@Schema(description = "Type of trade operation — BUY or REDEEM."`: *unknown*

  - `example = "BUY")
        TransactionType type`: *unknown*

  - `// enum below

        @Schema(description = "Symbol of the mutual fund involved in the trade."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Number of units bought or redeemed."`: *unknown*

  - `example = "10.00000000")
        BigDecimal units`: *unknown*

  - `@Schema(description = "Net Asset Value (NAV) per unit used for the trade."`: *unknown*

  - `example = "51.245600"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal nav`: *unknown*

  - `@Schema(description = "Total trade amount = units × NAV."`: *unknown*

  - `example = "512.456000"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal amount`: *unknown*

  - `@Schema(description = "Timestamp when the trade was executed."`: *unknown*

  - `example = "2025-10-28T14:32:55Z"`: *unknown*

  - `format = "date-time"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        Instant ts`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/TradeDto.java`


**HoldingDto** (record)  

- Fields:

  - `@Schema(description = "Symbol of the mutual fund."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Number of units currently held."`: *unknown*

  - `example = "12.50000000")
        BigDecimal units`: *unknown*

  - `@Schema(description = "Today's Net Asset Value (NAV) per unit for this fund."`: *unknown*

  - `example = "50.000000"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal todayNav`: *unknown*

  - `@Schema(description = "Total value of this holding = units × today's NAV."`: *unknown*

  - `example = "625.000000"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal valueToday`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/HoldingDto.java`


**NavReq** (record)  

- Fields:

  - `@NotNull
        @DecimalMin(value = "0.0001"`: *unknown*

  - `inclusive = false)
        @Schema(
                description = "Today's Net Asset Value (NAV) per unit. Must be greater than 0.0001."`: *unknown*

  - `example = "51.245600"
        )
        BigDecimal nav`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/NavReq.java`


**FundDto** (record)  

- Fields:

  - `@Schema(description = "Unique fund symbol identifier (ticker-like)."`: *unknown*

  - `example = "ALPHA")
        String symbol`: *unknown*

  - `@Schema(description = "Display name of the mutual fund."`: *unknown*

  - `example = "Alpha Growth Fund")
        String name`: *unknown*

  - `@Schema(description = "Today's Net Asset Value (NAV) per unit."`: *unknown*

  - `example = "51.245600"`: *unknown*

  - `accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal todayNav`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/FundDto.java`


**PrincipalDto** (record)  

- Fields:

  - `@Schema(example = "gokul") String username`: *unknown*

  - `@Schema(description = "Granted authorities") List<String> roles`: *unknown*

- Source: `mfms/src/main/java/com/acme/mutualfund/dto/PrincipalDto.java`

