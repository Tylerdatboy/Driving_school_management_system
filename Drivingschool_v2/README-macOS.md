# 驾校管理系统 - macOS安装运行指南

本指南提供了在macOS系统上运行驾校管理系统的步骤。

## 系统要求
- macOS系统
- Java JDK 8或更高版本
- Node.js和npm
- MySQL数据库

## 安装步骤

### 1. 安装数据库
确保MySQL数据库已安装并运行。如果尚未安装，可以通过Homebrew安装：
```
brew install mysql
brew services start mysql
```

然后创建数据库并导入初始数据：
```
mysql -u root -p -e "CREATE DATABASE drivingschool CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;"
mysql -u root -p drivingschool < db/springbootwn7i7.sql
```

### 2. 修改数据库配置
根据您的MySQL配置修改以下文件中的数据库连接参数：`src/main/resources/application.yml`

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/drivingschool?characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&autoReconnect=true&allowMultiQueries=true
    username: root   # 修改为您的MySQL用户名
    password: 123456 # 修改为您的MySQL密码
```

### 3. 运行后端服务
在项目根目录执行以下命令启动后端服务：
```
./run-backend.sh
```

### 4. 运行前端（面向用户界面）
打开一个新的终端窗口，执行以下命令：
```
cd src/main/resources/front/front
./install.sh  # 首次运行时安装依赖
./run.sh      # 启动前端服务
```

### 5. 运行管理员界面
打开一个新的终端窗口，执行以下命令：
```
cd src/main/resources/admin/admin
./1-install.sh  # 首次运行时安装依赖
./2-run.sh      # 启动管理界面服务
```

## 访问系统
- 用户前端: [http://localhost:8080](http://localhost:8080)
- 管理后台: [http://localhost:8081](http://localhost:8081)

## 可能的问题及解决方案

### 1. Maven相关错误
如果运行后端服务时出现Maven相关错误，可尝试安装Maven并使用它来运行：
```
brew install maven
mvn spring-boot:run
```

### 2. Node.js依赖问题
如果出现依赖相关错误，尝试使用以下命令：
```
npm cache clean --force
rm -rf node_modules
npm install
```

### 3. 端口冲突
如果端口被占用，可以修改以下文件中的端口配置：
- 后端端口：`src/main/resources/application.yml`
- 前端端口：`src/main/resources/front/front/vue.config.js`
- 管理端端口：`src/main/resources/admin/admin/vue.config.js` 