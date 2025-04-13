<template>
  <el-container class="main-container">
    <!-- 左侧导航 -->
    <el-aside width="300px" class="left-side">
      <div class="logo">Driving Test Learning Platform</div>
      <el-menu
          default-active="1"
          background-color="#304156"
          text-color="#fff"
          active-text-color="#409EFF"
      >
        <el-menu-item index="1">
          <i class="el-icon-notebook-2"></i>
          <span>Subject 1 (Traffic Regulations)</span>
        </el-menu-item>
        <el-menu-item index="2">
          <i class="el-icon-guide"></i>
          <span>Subject Four (Safety and Civilization)</span>
        </el-menu-item>
      </el-menu>
    </el-aside>

    <!-- 右侧主内容 -->
    <el-container>
      <el-header class="header">
      </el-header>

      <el-main class="content-area">
        <div class="function-cards">
          <!-- 模拟考试模块 -->
          <el-card
              class="card-item"
              shadow="hover"
              @click.native="handleExamClick">
            <div class="card-content">
              <i class="el-icon-timer"></i>
              <h3>Simulated Exam</h3>
              <p>Full simulation exam environment</p>
              <el-button type="primary">Start the exam</el-button>
            </div>
          </el-card>

          <!-- 顺序练习模块 -->
          <el-card
              class="card-item"
              shadow="hover"
              @click.native="handlePracticeClick">
            <div class="card-content">
              <i class="el-icon-document"></i>
              <h3>Sequential Practice</h3>
              <p>Learn all questions in order</p>
              <el-button type="success">Start practicing</el-button>
            </div>
          </el-card>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  methods: {
    handleExamClick() {
      // 处理模拟考试点击事件
      console.log('进入模拟考试');
    },
    handlePracticeClick() {
      // 处理顺序练习点击事件
      console.log('进入顺序练习');
    }
  }
}
</script>

<style scoped>
.main-container {
  height: 100vh;
}

.left-side {
  background: #304156;
}

.logo {
  height: 60px;
  line-height: 60px;
  color: #fff;
  text-align: center;
  background: #263445;
}

.header {
  border-bottom: 1px solid #e6e6e6;
  display: flex;
  align-items: center;
}

.header-title {
  font-size: 20px;
  color: #409EFF;
  font-weight: bold;
}

.content-area {
  background: #f5f7f9;
  padding: 20px;
}

.function-cards {
  display: flex;
  gap: 20px;
}

.card-item {
  width: 300px;
  cursor: pointer;
  transition: transform 0.3s;
}

.card-item:hover {
  transform: translateY(-5px);
}

.card-content {
  text-align: center;
  padding: 20px;
}

.card-content i {
  font-size: 40px;
  margin-bottom: 15px;
  color: #409EFF;
}

.card-content h3 {
  margin: 10px 0;
  color: #333;
}

.card-content p {
  color: #666;
  margin-bottom: 15px;
}
</style>
