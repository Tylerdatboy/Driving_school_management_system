<template>
  <div class="schedule-container">
    <!-- 教练选择 -->
    <el-select
        v-model="selectedCoach"
        placeholder="请选择教练"
        class="select-item"
    >
      <el-option
          v-for="coach in coaches"
          :key="coach.id"
          :label="coach.name"
          :value="coach.id"
      />
    </el-select>

    <!-- 日期选择 -->
    <el-date-picker
        v-model="selectedDate"
        type="date"
        placeholder="选择预约日期"
        value-format="yyyy-MM-dd"
        class="select-item"
    />

    <!-- 查询按钮 -->
    <el-button
        type="primary"
        :disabled="!selectedCoach || !selectedDate"
        @click="fetchSchedule"
        class="query-btn"
    >
      查询可约时段
    </el-button>

    <!-- 时间表展示 -->
    <div v-if="schedule" class="time-table">
      <div class="time-slots">
        <el-button
            v-for="(slot, index) in timeSlots"
            :key="index"
            :type="selectedSlot === index ? 'primary' : ''"
            :disabled="slot.booked"
            @click="selectTimeSlot(index)"
            class="time-btn"
        >
          <div class="slot-content">
            <div>{{ slot.label }}</div>
            <div class="time-range">{{ slot.range }}</div>
            <div v-if="slot.booked" class="booked-tip">已预约</div>
          </div>
        </el-button>
      </div>

      <!-- 确认按钮 -->
      <el-button
          v-if="selectedSlot !== null"
          type="success"
          @click="confirmBooking"
          class="confirm-btn"
      >
        确认预约
      </el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      coaches: [
        { id: 1, name: '王教练' },
        { id: 2, name: '李教练' },
        { id: 3, name: '张教练' }
      ],
      selectedCoach: null,
      selectedDate: null,
      schedule: null,
      selectedSlot: null,
      timeSlots: [
        { label: '上午第一节', range: '08:00-10:00', booked: false },
        { label: '上午第二节', range: '10:00-12:00', booked: false },
        { label: '下午第一节', range: '14:00-16:00', booked: false },
        { label: '下午第二节', range: '16:00-18:00', booked: false }
      ]
    }
  },
  methods: {
    // 模拟API请求获取教练日程
    fetchSchedule() {
      // 此处应替换为真实API调用
      this.schedule = this.getMockSchedule()
      this.selectedSlot = null
    },

    // 模拟数据生成
    getMockSchedule() {
      // 随机生成已预约时段
      return this.timeSlots.map(slot => ({
        ...slot,
        booked: Math.random() > 0.5
      }))
    },

    // 选择时间段
    selectTimeSlot(index) {
      this.selectedSlot = this.timeSlots[index].booked ? null : index
    },

    // 确认预约
    confirmBooking() {
      if (this.selectedSlot !== null) {
        this.$confirm('确认预约该时段吗？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // 此处应添加实际预约API调用
          this.$message.success('预约成功！')
          this.resetForm()
        }).catch(() => {
          this.$message.info('已取消预约')
        })
      }
    },

    // 重置表单
    resetForm() {
      this.schedule = null
      this.selectedSlot = null
      this.selectedCoach = null
      this.selectedDate = null
    }
  }
}
</script>

<style scoped>
.schedule-container {
  max-width: 800px;
  margin: 20px auto;
  padding: 20px;
}

.select-item {
  margin-right: 15px;
  width: 200px;
}

.query-btn {
  margin-left: 15px;
}

.time-table {
  margin-top: 30px;
}

.time-slots {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 15px;
  margin-bottom: 30px;
}

.time-btn {
  height: 80px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.slot-content {
  text-align: center;
  line-height: 1.5;
}

.time-range {
  color: #666;
  font-size: 0.9em;
}

.booked-tip {
  color: #ff4444;
  font-size: 0.8em;
  margin-top: 5px;
}

.confirm-btn {
  display: block;
  margin: 0 auto;
  width: 200px;
}
</style>
