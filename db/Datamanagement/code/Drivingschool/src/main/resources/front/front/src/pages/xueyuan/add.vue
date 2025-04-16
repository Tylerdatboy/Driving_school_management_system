<template>
<div :style='{"width":"100%","padding":"40px 7%","margin":"0 auto","position":"relative","background":"none"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="150px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="Student account" prop="xueyuanzhanghao">
            <el-input v-model="ruleForm.xueyuanzhanghao"
                placeholder="Student account" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="password" prop="mima">
            <el-input v-model="ruleForm.mima"
                placeholder="password" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="Student name" prop="xueyuanxingming">
            <el-input v-model="ruleForm.xueyuanxingming"
                placeholder="Student name" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}'  label="gender" prop="xingbie">
            <el-select v-model="ruleForm.xingbie" placeholder="Please select gender"  >
              <el-option
                  v-for="(item,index) in xingbieOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="Student mobile phone" prop="xueyuanshouji">
            <el-input v-model="ruleForm.xueyuanshouji"
                placeholder="Student mobile phone" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="ID" prop="shenfenzheng">
            <el-input v-model="ruleForm.shenfenzheng"
                placeholder="ID" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="picture" v-if="type!='cross' || (type=='cross' && !ro.touxiang)" prop="touxiang">
            <file-upload
            tip="Click to upload picture"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
            @change="touxiangUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' class="upload" v-else label="picture" prop="touxiang">
                <img v-if="ruleForm.touxiang.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.touxiang.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.touxiang.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="security question" prop="pquestion">
            <el-input v-model="ruleForm.pquestion"
                placeholder="security question" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","alignItems":"center","background":"linear-gradient(90deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","display":"flex"}' label="Secret Answer" prop="panswer">
            <el-input v-model="ruleForm.panswer"
                placeholder="Secret Answer" clearable ></el-input>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"30px 0 20px 140px"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 10px","color":"#fff","minWidth":"140px","outline":"none","borderRadius":"10px","background":"linear-gradient(90deg, rgba(32,173,158,1) 0%, rgba(138,228,219,1) 50%, rgba(32,173,158,1) 100%),#20ad9e","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}'  type="primary" @click="onSubmit">submit</el-button>
        <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0 15px","margin":"0 10px","color":"#fff","minWidth":"140px","outline":"none","borderRadius":"10px","background":"linear-gradient(90deg, rgba(153,153,153,1) 0%, rgba(204,204,204,1) 50%, rgba(153,153,153,1) 100%),#999","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}' @click="back()">return</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            xueyuanzhanghao : false,
            mima : false,
            xueyuanxingming : false,
            xingbie : false,
            xueyuanshouji : false,
            shenfenzheng : false,
            touxiang : false,
            pquestion : false,
            panswer : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          xueyuanzhanghao: '',
          mima: '',
          xueyuanxingming: '',
          xingbie: '',
          xueyuanshouji: '',
          shenfenzheng: '',
          touxiang: '',
          pquestion: '',
          panswer: '',
        },
        xingbieOptions: [],
        rules: {
          xueyuanzhanghao: [
            { required: true, message: 'Student accountCannot be empty', trigger: 'blur' },
          ],
          mima: [
            { required: true, message: 'passwordCannot be empty', trigger: 'blur' },
          ],
          xueyuanxingming: [
          ],
          xingbie: [
          ],
          xueyuanshouji: [
            { validator: this.$validate.isMobile, trigger: 'blur' },
          ],
          shenfenzheng: [
            { validator: this.$validate.isIdCard, trigger: 'blur' },
          ],
          touxiang: [
          ],
          pquestion: [
          ],
          panswer: [
          ],
        },
      };
    },
    computed: {



    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='xueyuanzhanghao'){
              this.ruleForm.xueyuanzhanghao = obj[o];
              this.ro.xueyuanzhanghao = true;
              continue;
            }
            if(o=='mima'){
              this.ruleForm.mima = obj[o];
              this.ro.mima = true;
              continue;
            }
            if(o=='xueyuanxingming'){
              this.ruleForm.xueyuanxingming = obj[o];
              this.ro.xueyuanxingming = true;
              continue;
            }
            if(o=='xingbie'){
              this.ruleForm.xingbie = obj[o];
              this.ro.xingbie = true;
              continue;
            }
            if(o=='xueyuanshouji'){
              this.ruleForm.xueyuanshouji = obj[o];
              this.ro.xueyuanshouji = true;
              continue;
            }
            if(o=='shenfenzheng'){
              this.ruleForm.shenfenzheng = obj[o];
              this.ro.shenfenzheng = true;
              continue;
            }
            if(o=='touxiang'){
              this.ruleForm.touxiang = obj[o].split(",")[0];
              this.ro.touxiang = true;
              continue;
            }
            if(o=='pquestion'){
              this.ruleForm.pquestion = obj[o];
              this.ro.pquestion = true;
              continue;
            }
            if(o=='panswer'){
              this.ruleForm.panswer = obj[o];
              this.ro.panswer = true;
              continue;
            }
          }
        }
        // 获取User 信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
        this.xingbieOptions = "man,woman".split(',')
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('xueyuan/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // submit
      onSubmit() {

        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('xueyuan/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('xueyuan/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: 'operate success',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('xueyuan/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: 'operate success',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // return
      back() {
        this.$router.go(-1);
      },
      touxiangUploadChange(fileUrls) {
          this.ruleForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}

	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 15px;
	  color: #992298;
	  font-weight: 500;
	  width: 150px;
	  font-size: 15px;
	  line-height: 40px;
	  text-align: right;
	}

	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}

	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 0;
	  border-radius: 0;
	  padding: 0 10px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  background: #fff;
	  width: 360px;
	  font-size: 14px;
	  line-height: 32px;
	  height: 32px;
	}

	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 0;
	  border-radius: 0;
	  padding: 0 30px 0 10px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  background: #fff;
	  width: 320px;
	  font-size: 14px;
	  line-height: 32px;
	  height: 32px;
	}

	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 0;
	  border-radius: 0;
	  padding: 0 10px 0 30px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  background: #fff;
	  width: 400px;
	  font-size: 14px;
	  line-height: 32px;
	  height: 32px;
	}

	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}

	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px dashed #992298;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #992298;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}

	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px dashed #992298;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #992298;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}

	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px dashed #992298;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #992298;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}

	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 0;
	  border-radius: 0;
	  padding: 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
