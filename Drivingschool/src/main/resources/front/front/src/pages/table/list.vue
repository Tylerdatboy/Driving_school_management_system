<template>
  <div class="schedule-container">
    <!-- 顶部操作栏 -->
    <div class="operation-bar">
      <el-select
          v-model="selectedCoach"
          placeholder="Please choose a coach"
          class="select-item"
      >
        <el-option
            v-for="coach in coaches"
            :key="coach.id"
            :label="coach.name"
            :value="coach.id"
        />
      </el-select>

      <el-date-picker
          v-model="selectedWeek"
          type="week"
          format="yyyy Week WW"
          value-format="yyyy-MM-dd"
          placeholder="Select Week"
          class="select-item"
          @change="handleWeekChange"
      />

      <el-button
          type="primary"
          :disabled="!selectedCoach || !selectedWeek"
          @click="fetchSchedule"
          class="query-btn"
      >
        Search for this week's time slot
      </el-button>
    </div>

    <!-- 时间表主体 -->
    <div v-if="schedule" class="timetable-wrapper">
      <div class="timetable">
        <!-- 表头 -->
        <div class="timetable-header">
          <div class="time-header">period of time</div>
          <div
              v-for="(day, index) in weekDays"
              :key="index"
              class="day-header"
              :class="{ weekend: index >= 5 }"
          >
            <div class="date-display">{{ formatDateDisplay(day.date) }}</div>
            <div class="weekday-display">{{ day.weekday }}</div>
          </div>
        </div>

        <!-- 时间行 -->
        <div
            v-for="(timeSlot, tIndex) in timeSlots"
            :key="tIndex"
            class="timetable-row"
        >
          <div class="time-label">
            {{ timeSlot.label }}<br>
            <span class="time-range">{{ timeSlot.range }}</span>
          </div>
          <div
              v-for="(day, dIndex) in weekDays"
              :key="dIndex"
              class="time-cell"
          >
            <el-button
                :type="isSelected(day.date, tIndex) ? 'primary' : ''"
                :disabled="isDisabled(day.date, tIndex)"
                @click="selectSlot(day.date, tIndex)"
                class="slot-btn"
            >
              <div v-if="isBooked(day.date, tIndex)" class="status-tip booked">
                <i class="el-icon-close"></i>
                <span>already full</span>
              </div>
              <div v-else class="status-tip available">
                <i class="el-icon-check"></i>
                <span>reducible</span>
              </div>
            </el-button>
          </div>
        </div>
      </div>
    </div>

    <!-- 底部操作 -->
    <div v-if="selectedSlot" class="bottom-bar">
      <el-button
          type="success"
          @click="confirmBooking"
          class="confirm-btn"
      >
        确认预约 {{ selectedSlot.date }} {{ timeSlots[selectedSlot.timeIndex].range }}
      </el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      coaches: [
        {id: 1, name: '王教练'},
        {id: 2, name: '李教练'},
        {id: 3, name: '张教练'}
      ],
      selectedCoach: null,
      selectedWeek: null,
      weekDays: [],
      timeSlots: [
        {label: 'Morning   Session1', range: '08:00-10:00'},
        {label: 'Morning   Session2', range: '10:00-12:00'},
        {label: 'Afternoon Session1', range: '14:00-16:00'},
        {label: 'Afternoon Session2', range: '16:00-18:00'},
        {label: 'Evening Session', range: '19:00-21:00'}

      ],
      schedule: null,
      type:'',
      selectedSlot: null
    }
  },
  created() {
    this.$http.get('users/type').then(res => {
      console.log(res)
      this.type = res.data.data.tableName;
      if (this.type==='xueyuan'){
        this.$http.get('users/select').then(res => {
          console.log(res)
          this.coaches = res.data.data;
        });
      }else {
       this.coaches =[
         {id: res.data.data.id, name:res.data.data.username},
       ]
        this.$message.success('There are new course appointments, please check the schedule')
      }

    });
  },
  methods: {
    handleWeekChange(date) {
      const startDate = new Date(date)
      const dayOfWeek = startDate.getDay() || 7 // 周日返回0时转为7
      const monday = new Date(startDate)
      monday.setDate(monday.getDate() - dayOfWeek + 1)

      this.weekDays = Array.from({length: 7}, (_, i) => {
        const d = new Date(monday)
        d.setDate(d.getDate() + i)
        return {
          date: this.formatDate(d),
         weekday:  ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'] [i]
        }
      })
    },

    formatDate(date) {
      const year = date.getFullYear()
      const month = (date.getMonth() + 1).toString().padStart(2, '0')
      const day = date.getDate().toString().padStart(2, '0')
      return `${year}-${month}-${day}`
    },

    formatDateDisplay(dateString) {
      const [year, month, day] = dateString.split('-')
      return `${month}月${day}日`
    },

    /* fetchSchedule() {
       // 模拟API请求
       this.schedule = this.weekDays.reduce((acc, day) => {
         console.log("11111111111111111111")
         console.log(day)
         acc[day.date] = this.timeSlots.map(() => Math.random() > 0.7)
         return acc
       }, {})
       this.selectedSlot = null
     },*/
    fetchSchedule() {
      try {
        var params = {
          selectedCoach: this.selectedCoach,
          dates: this.weekDays.map(day => day.date) // 发送日期数组
        }
          this.$http.post('users/schedule', params).then(res => {
            this.schedule = res.data.data.timeType;

        });


      } catch (error) {
        console.error('获取数据失败:', error)
        // 可添加错误处理
      }
    },
    insert() {
      try {
        var params = {
          selectedCoach: this.selectedCoach,
          date: this.selectedSlot.date,
          range:this.timeSlots[this.selectedSlot.timeIndex].range // 发送日期数组
        }
          this.$http.post('users/insert', params).then(res => {
            console.log(res)
            this.fetchSchedule()
            this.$message.success('Appointment successful!')
        });


      } catch (error) {
        console.error('获取数据失败:', error)
        // 可添加错误处理
      }
    },

    isDisabled(date, timeIndex) {
      const now = new Date()
      const slotDate = new Date(date)
      const [startHour] = this.timeSlots[timeIndex].range.split(':')
      slotDate.setHours(parseInt(startHour))

      return slotDate < now || this.isBooked(date, timeIndex)
    },

    isBooked(date, timeIndex) {
      return this.schedule[date][timeIndex]
    },

    selectSlot(date, timeIndex) {
      this.selectedSlot = {date, timeIndex}
    },

    isSelected(date, timeIndex) {
      return this.selectedSlot?.date === date &&
          this.selectedSlot?.timeIndex === timeIndex
    },

    confirmBooking() {
      this.$confirm(`Confirm appointment ${this.selectedSlot.date} ${this.timeSlots[this.selectedSlot.timeIndex].range} ？`, 'Confirm appointment', {
        confirmButtonText: 'sure',
        cancelButtonText: 'cancel',
        type: 'warning'
      }).then(() => {

        this.insert()

      }).catch(() => {
      })
    }
  }
}
</script>

<style scoped>
.schedule-container {
  max-width: 1200px;
  margin: 20px auto;
  padding: 0 20px;
}

.operation-bar {
  display: flex;
  gap: 15px;
  margin-bottom: 20px;
  flex-wrap: wrap;
}

.select-item {
  width: 200px;
}

.timetable-wrapper {
  border: 1px solid #ebeef5;
  border-radius: 8px;
  padding: 10px;
  background: #fff;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, .1);
}

.timetable {
  min-width: 1000px;
  overflow-x: auto;
}

.timetable-header,
.timetable-row {
  display: flex;
  min-height: 60px;
}

.time-header,
.day-header,
.time-label,
.time-cell {
  flex: 1;
  min-width: 120px;
  padding: 12px;
  text-align: center;
  border-right: 1px solid #ebeef5;
  border-bottom: 1px solid #ebeef5;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}

.time-header {
  background: #f5f7fa;
  font-weight: bold;
  color: #606266;
}

.day-header {
  background: #f8f9fb;
  color: #606266;
  line-height: 1.4;

&
.weekend {
  background: #fef4ec;

.date-display, .weekday-display {
  color: #e6a23c;
}

}
}

.date-display {
  font-size: 14px;
  margin-bottom: 2px;
}

.weekday-display {
  font-size: 13px;
  color: #909399;
}

.time-label {
  background: #fafafa;
  color: #909399;

.time-range {
  font-size: 12px;
  color: #c0c4cc;
}

}

.time-cell {
  padding: 5px;
}

.slot-btn {
  width: 100%;
  height: 100%;
  min-height: 50px;
  transition: all 0.2s;

&
:hover:not(.is-disabled) {
  transform: scale(1.05);
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

}

.status-tip {
  font-size: 12px;
  line-height: 1.4;

&
.booked {
  color: #f56c6c;
}

&
.available {
  color: #67c23a;
}

i {
  display: block;
  font-size: 16px;
  margin-bottom: 3px;
}

}

.bottom-bar {
  margin-top: 20px;
  text-align: center;
}

.confirm-btn {
  width: 300px;
  height: 45px;
  font-size: 16px;
}

@media (max-width: 768px) {
  .schedule-container {
    padding: 0 10px;
  }

  .operation-bar {
    gap: 10px;
  }

  .select-item {
    width: 100%;
  }

  .query-btn {
    width: 100%;
  }

  .date-display {
    font-size: 13px;
  }

  .weekday-display {
    font-size: 12px;
  }

  .time-header,
  .day-header,
  .time-label,
  .time-cell {
    min-width: 90px;
    padding: 8px;
  }

  .status-tip span {
    display: none;
  }

  .confirm-btn {
    width: 100%;
  }
}
</style>
