<template>
<div class="center-preview" :style='{"width":"100%","padding":"0 0 250px","margin":"0 auto","position":"relative","background":"url(http://codegen.caihongy.cn/20230131/bd3718741ba74578b2f69615121a81d9.jpg) no-repeat center bottom / 100% auto"}'>
	<div class="title" :style='{"margin":"10px 0","color":"#000","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230131/c788dee9481d4fd896e419a46388d74e.png) no-repeat center top","fontSize":"20px","lineHeight":"54px","fontWeight":"bold"}'>{{ title }}</div>

    <el-tabs tab-position="left" :style='{"width":"100%","background":"none"}' @tab-click="handleClick">
      <el-tab-pane label="Personal Center">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="150px">
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='xueyuan'" label="Student account" prop="xueyuanzhanghao">
            <el-input v-model="sessionForm.xueyuanzhanghao" placeholder="Student account" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='xueyuan'" label="password" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="password"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='xueyuan'" label="Student name" prop="xueyuanxingming">
            <el-input v-model="sessionForm.xueyuanxingming" placeholder="Student name" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='xueyuan'" label="gender">
            <el-select v-model="sessionForm.xingbie" placeholder="Please select gender" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='xueyuan'" label="Student mobile phone" prop="xueyuanshouji">
            <el-input v-model="sessionForm.xueyuanshouji" placeholder="Student mobile phone" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='xueyuan'" label="ID" prop="shenfenzheng">
            <el-input v-model="sessionForm.shenfenzheng" placeholder="ID" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='xueyuan'" label="picture">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="xueyuantouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px dashed #333","cursor":"pointer","margin":"10px 0","color":"#333","borderRadius":"6px","textAlign":"center","width":"100px","fontSize":"32px","lineHeight":"100px","height":"100px"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='xueyuan'" label="security question" prop="pquestion">
            <el-input v-model="sessionForm.pquestion" placeholder="security question" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='xueyuan'" label="Secret Answer" prop="panswer">
            <el-input v-model="sessionForm.panswer" placeholder="Secret Answer" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='jiaxiaojiaolian'" label="Coach account" prop="jiaolianzhanghao">
            <el-input v-model="sessionForm.jiaolianzhanghao" placeholder="Coach account" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='jiaxiaojiaolian'" label="password" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="password"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='jiaxiaojiaolian'" label="Coach Name" prop="jiaolianxingming">
            <el-input v-model="sessionForm.jiaolianxingming" placeholder="Coach Name" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='jiaxiaojiaolian'" label="age" prop="nianling">
            <el-input v-model="sessionForm.nianling" placeholder="age" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='jiaxiaojiaolian'" label="gender">
            <el-select v-model="sessionForm.xingbie" placeholder="Please select gender" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='jiaxiaojiaolian'" label="Length of teaching" prop="jiaoling">
            <el-input v-model="sessionForm.jiaoling" placeholder="Length of teaching" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='jiaxiaojiaolian'" label="picture">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="jiaxiaojiaoliantouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px dashed #333","cursor":"pointer","margin":"10px 0","color":"#333","borderRadius":"6px","textAlign":"center","width":"100px","fontSize":"32px","lineHeight":"100px","height":"100px"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='jiaxiaojiaolian'" label="Contact Number" prop="lianxidianhua">
            <el-input v-model="sessionForm.lianxidianhua" placeholder="Contact Number" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='jiaxiaojiaolian'" label="security question" prop="pquestion">
            <el-input v-model="sessionForm.pquestion" placeholder="security question" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"2px 10px","margin":"0 0 20px 0","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)"}' v-if="userTableName=='jiaxiaojiaolian'" label="Secret Answer" prop="panswer">
            <el-input v-model="sessionForm.panswer" placeholder="Secret Answer" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"0","alignItems":"center","justifyContent":"center","display":"flex"}'>
            <el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 20px","color":"#fff","minWidth":"130px","outline":"none","borderRadius":"10px","background":"linear-gradient(90deg, rgba(32,173,158,1) 0%, rgba(138,228,219,1) 50%, rgba(32,173,158,1) 100%),#20ad9e","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onSubmit('sessionForm')">Update information</el-button>
            <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0 20px","margin":"0 10px","color":"#fff","minWidth":"130px","outline":"none","borderRadius":"10px","background":"linear-gradient(90deg, rgba(153,153,153,1) 0%, rgba(204,204,204,1) 50%, rgba(153,153,153,1) 100%),#999","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="danger" @click="logout">Log Out</el-button>
          </el-form-item>
        </el-form>

        <el-dialog title="User Recharge" :visible.sync="dialogFormVisibleMoney" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="Recharge Amount of money" label-width="120px">
              <el-input type="number" v-model="chongzhiForm.money" autocomplete="off" placeholder="Recharge Amount of money"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="WeChat Pay">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">WeChat Pay</span>
                </el-radio>
                <el-radio label="Alipay payment">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">Alipay payment</span>
                </el-radio>
                <el-radio label="China Construction Bank Payment">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Payment by Agricultural Bank of China">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Bank of China Payment">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Bank of Communications payment">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleMoney = false">Cancel</el-button>
            <el-button type="primary" @click="chongzhi">Confirm Recharge</el-button>
          </div>
        </el-dialog>
        <el-dialog title="Member purchase" :visible.sync="dialogFormVisibleVip" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="membership card" label-width="120px">
              <el-input readonly autocomplete="off" value="￥199/Year"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="WeChat Pay">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">WeChat Pay</span>
                </el-radio>
                <el-radio label="Alipay payment">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">Alipay payment</span>
                </el-radio>
                <el-radio label="China Construction Bank Payment">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Payment by Agricultural Bank of China">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Bank of China Payment">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Bank of Communications payment">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleVip = false">Cancel</el-button>
            <el-button type="primary" @click="chongzhivip">Confirm Payment</el-button>
          </div>
        </el-dialog>
      </el-tab-pane>
      <el-tab-pane label="My Collection"></el-tab-pane>
    </el-tabs>
</div>
</template>

<script>
  import config from '@/config/config'
  import Vue from 'vue'
  export default {
    //数据集合
    data() {
      return {
        title: 'Personal Center',
        baseUrl: config.baseUrl,
        sessionForm: {},
        rules: {},
        chongzhiForm: {
          money: '',
          radio: ''
        },
        disabled: false,
        dialogFormVisibleMoney: false,
        dialogFormVisibleVip: false,
        uploadUrl: config.baseUrl + 'file/upload',
        imageUrl: '',
        headers: {Token: localStorage.getItem('Token')},
        userTableName: localStorage.getItem('UserTableName'),
        dynamicProp: {}
      }
    },
    created() {
      if ('xueyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'xueyuanzhanghao', null);
      }
      if ('xueyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('xueyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'xueyuanxingming', null);
      }
      if ('xueyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('xueyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'xueyuanshouji', null);
      }
      if ('xueyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'shenfenzheng', null);
      }
      if ('xueyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('xueyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'pquestion', null);
      }
      if ('xueyuan' == this.userTableName) {
        this.$set(this.sessionForm, 'panswer', null);
      }
      if ('jiaxiaojiaolian' == this.userTableName) {
        this.$set(this.sessionForm, 'jiaolianzhanghao', null);
      }
      if ('jiaxiaojiaolian' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('jiaxiaojiaolian' == this.userTableName) {
        this.$set(this.sessionForm, 'jiaolianxingming', null);
      }
      if ('jiaxiaojiaolian' == this.userTableName) {
        this.$set(this.sessionForm, 'nianling', null);
      }
      if ('jiaxiaojiaolian' == this.userTableName) {
        this.$set(this.sessionForm, 'xingbie', null);
      }
      if ('jiaxiaojiaolian' == this.userTableName) {
        this.$set(this.sessionForm, 'jiaoling', null);
      }
      if ('jiaxiaojiaolian' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('jiaxiaojiaolian' == this.userTableName) {
        this.$set(this.sessionForm, 'lianxidianhua', null);
      }
      if ('jiaxiaojiaolian' == this.userTableName) {
        this.$set(this.sessionForm, 'gerenjieshao', null);
      }
      if ('jiaxiaojiaolian' == this.userTableName) {
        this.$set(this.sessionForm, 'pquestion', null);
      }
      if ('jiaxiaojiaolian' == this.userTableName) {
        this.$set(this.sessionForm, 'panswer', null);
      }

      if ('xueyuan' == this.userTableName) {
        this.$set(this.rules, 'xueyuanzhanghao', [{ required: true, message: 'Enter Student account', trigger: 'blur' }]);
      }
      if ('xueyuan' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: 'Please input a password', trigger: 'blur' }]);
      }
			if ('xueyuan' == this.userTableName) {
        this.$set(this.rules, 'xueyuanshouji', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
			if ('xueyuan' == this.userTableName) {
        this.$set(this.rules, 'shenfenzheng', [{ required: false, validator: this.$validate.isIdCard, trigger: 'blur' }]);
      }
      if ('jiaxiaojiaolian' == this.userTableName) {
        this.$set(this.rules, 'jiaolianzhanghao', [{ required: true, message: 'Enter Coach account', trigger: 'blur' }]);
      }
      if ('jiaxiaojiaolian' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: 'Please input a password', trigger: 'blur' }]);
      }
			if ('jiaxiaojiaolian' == this.userTableName) {
        this.$set(this.rules, 'nianling', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
      }
			if ('jiaxiaojiaolian' == this.userTableName) {
        this.$set(this.rules, 'lianxidianhua', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }

      this.init();
      this.getSession();
    },
    //方法集合
    methods: {
      init() {
        if ('xueyuan' == this.userTableName) {
          this.dynamicProp.xingbie = 'man,woman'.split(',');
        }
        if ('jiaxiaojiaolian' == this.userTableName) {
          this.dynamicProp.xingbie = 'man,woman'.split(',');
        }
      },
      getSession() {
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.sessionForm = res.data.data;
            localStorage.setItem('userid', res.data.data.id);
            if(res.data.data.vip) {
                localStorage.setItem('vip', res.data.data.vip);
            }
            if(res.data.data.touxiang) {
                localStorage.setItem('headportrait', res.data.data.touxiang);
            } else if(res.data.data.headportrait) {
                localStorage.setItem('headportrait', res.data.data.headportrait);
            }
          }
        });
      },
      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
              if (res.data.code == 0) {
                this.$message({
                  message: '更新 success',
                  type: 'success',
                  duration: 1500
                });
              }
            });
          } else {
            return false;
          }
        });
      },
      xueyuantouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('xueyuan' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      jiaxiaojiaoliantouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('jiaxiaojiaolian' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      chongzhi() {
        if (this.chongzhiForm.money == '') {
          this.$message({
            message: 'Please enter the recharge amount',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.money <= 0) {
          this.$message({
            message: 'Please enter the correct recharge amount',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: 'Please select Recharge method',
            type: 'error',
            duration: 1500
          });
          return;
        }
        this.sessionForm.money = parseInt(this.sessionForm.money) + parseInt(this.chongzhiForm.money);
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: 'Recharge success',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.dialogFormVisibleMoney = false;
              }
            });
          }
        });
      },
      chongzhivip() {
        this.chongzhiForm.money == 199;
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: 'Please select Payment method',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if(this.sessionForm.vip == '是') {
          this.$message({
            message: 'You are already our esteemed member。',
            type: 'success',
            duration: 1500
          });
          return;
        }

        this.sessionForm.vip = "是"
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: 'Member purchase success',
              type: 'success',
              duration: 1500,
              onClose: () => {
                localStorage.setItem('vip', this.sessionForm.vip);
                this.dialogFormVisibleVip = false;
              }
            });
          }
        });
      },
      handleClick(tab, event) {
        switch(event.target.outerText) {
          case 'Personal Center':
            tab.$router.push('/index/center');
            break;
          case 'My Collection':
            localStorage.setItem('storeupType', 1);
            tab.$router.push('/index/storeup');
            break;
        }

        this.title = event.target.outerText;
      },
      logout() {
        localStorage.clear();
        Vue.http.headers.common['Token'] = "";
        this.$router.push('/index/home');
        this.activeIndex = '0'
        localStorage.setItem('keyPath', this.activeIndex)
        this.$forceUpdate()
        this.$message({
            message: 'Log out  success',
            type: 'success',
            duration: 1500,
        });
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .center-preview {

    .el-tabs {
      & /deep/ .el-tabs__header {
        .el-tabs__nav-wrap {
          margin: 0;

          &::after {
            content: none;
          }
        }

        .el-tabs__active-bar {
          display: none !important;
        }
      }

      .center-preview-pv {
        .el-date-editor.el-input {
          width: auto;
        }

        .balance {
          .el-input {
            width: auto;
          }
        }
      }
    }
  }

  .center-preview .el-tabs /deep/ .el-tabs__header {
	padding: 20px 0 10px;
	margin: 20px 7% 0 0;
	background: linear-gradient(280deg, rgba(151,36,152,1) 0%, rgba(32,173,158,1) 100%);
	width: 250px;
	border-color: #eee;
	border-width: 0;
	position: relative;
	float: right;
	border-style: solid;
  }

  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  	padding: 0 10px;
  	margin: 10px auto;
  	color: #333;
  	white-space: nowrap;
  	font-weight: 500;
  	font-size: 14px;
  	border-color: #ccc;
  	line-height: 40px;
  	text-overflow: ellipsis;
  	border-radius: 20px;
  	overflow: hidden;
  	background: #fff;
  	width: 80%;
  	border-width: 8px 4px;
  	position: relative;
  	border-style: solid;
  	text-align: center;
  	height: 56px;
  }

  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  	border: 0 solid #8dd4cc;
  	border-radius: 20px;
  	padding: 0 10px;
  	color: 333;
  	background: #fff;
  	font-weight: 500;
  	font-size: 16px;
  	border-width: 8px 4px;
  	line-height: 40px;
  	position: relative;
  	text-align: center;
  	height: 56px;
  }

  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  	border: 0 solid #8dd4cc;
  	padding: 0 10px;
  	margin: 10px auto;
  	color: #333;
  	font-weight: bold;
  	font-size: 16px;
  	line-height: 40px;
  	border-radius: 20px;
  	background: #fff;
  	width: 80%;
  	border-width: 8px 4px;
  	position: relative;
  	text-align: center;
  	height: 56px;
  }

  .center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  	padding: 10px;
  	margin: 20px 7% 0;
  	background: none;
  	width: calc(100% - 240px);
  	float: left;
  }

  .center-preview-pv .el-form-item /deep/ .el-form-item__label {
  	padding: 0 15px;
  	color: #992298;
  	font-weight: 500;
  	width: 150px;
  	font-size: 15px;
  	line-height: 40px;
  	text-align: center;
  }

  .center-preview-pv .el-form-item .el-form-item__content {
    margin-left: 150px;
  }

  .center-preview-pv .el-input /deep/ .el-input__inner {
  	border: 0;
  	border-radius: 0;
  	padding: 0 12px;
  	color: #555;
  	width: 400px;
  	font-size: 14px;
  	height: 32px;
  }

  .center-preview-pv .el-select /deep/ .el-input__inner {
  	border: 0;
  	border-radius: 0;
  	padding: 0 12px;
  	color: #555;
  	width: 400px;
  	font-size: 14px;
  	height: 32px;
  }

  .center-preview-pv .el-date-editor /deep/ .el-input__inner {
  	border: 0;
  	border-radius: 0;
  	padding: 0 10px 0 30px;
  	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  	outline: none;
  	color: #555;
  	width: 200px;
  	font-size: 14px;
  	height: 32px;
  }

  .center-preview-pv /deep/ .avatar-uploader-icon {
  	border: 1px dashed #333;
  	cursor: pointer;
  	border-radius: 6px;
  	margin: 10px 0;
  	color: #333;
  	width: 100px;
  	font-size: 32px;
  	line-height: 100px;
  	text-align: center;
  	height: 100px;
  }

  .center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  	border: 0;
  	border-radius: 0;
  	padding: 0 12px;
  	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
  	outline: none;
  	color: 555;
  	display: inline-block;
  	width: 200px;
  	font-size: 14px;
  	height: 32px;
  }
</style>
