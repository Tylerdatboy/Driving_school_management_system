<template>
	<div class="main-content" :style='{"padding":"10px 30px"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"width":"100%","margin":"0 0 20px","flexWrap":"wrap","display":"flex"}' :inline="true" :model="searchForm">
				<el-row :style='{"width":"100%","display":"block","order":"2"}' >
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">Coach account</label>
						<el-input v-model="searchForm.jiaolianzhanghao" placeholder="Coach account" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">Student account</label>
						<el-input v-model="searchForm.xueyuanzhanghao" placeholder="Student account" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}' class="select" label="Practice subjects" prop="lianxikemu">
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">Practice subjects</label>
						<el-select  @change="lianxikemuChange" clearable v-model="searchForm.lianxikemu" placeholder="Please select Practice subjects">
							<el-option v-for="(item,index) in lianxikemuOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}' class="select">
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"40px","fontSize":"14px","fontWeight":"500","height":"40px"}' class="item-label">Did it pass</label>
						<el-select  @change="sfshChange" clearable v-model="searchForm.sfsh" placeholder="Did it pass">
							<el-option v-for="(item,index) in sfshOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<el-button :style='{"cursor":"pointer","padding":"0 30px","boxShadow":"4px 4px 2px #ddd","borderColor":"#798fe1","margin":"0 0 0 10px","color":"#798fe1","outline":"none","borderRadius":"0","background":"#eaf2fa","borderWidth":"4px","width":"auto","fontSize":"16px","lineHeight":"40px","borderStyle":"solid double solid double","height":"44px"}' type="success" @click="search()">query</el-button>
				</el-row>

				<el-row :style='{"width":"100%","padding":"0","margin":"20px 0 20px","background":"none","display":"flex"}'>
					<el-button :style='{"border":"1px dotted #a347ea","cursor":"pointer","padding":"0 24px","margin":"0 10px 0 0","outline":"none","color":"#a347ea","borderRadius":"0px","background":"#f3eafa","width":"auto","fontSize":"14px","height":"40px"}' v-if="isAuth('yuyuelianxi','新增')" type="success" @click="addOrUpdateHandler()">新增</el-button>
					<el-button :style='{"border":"1px dotted #df2543","cursor":"pointer","padding":"0 24px","margin":"0 10px 0 0","outline":"none","color":"#df2543","borderRadius":"0px","background":"#fcecef","width":"auto","fontSize":"14px","height":"40px"}' v-if="isAuth('yuyuelianxi','delete')" :disabled="dataListSelections.length <= 0" type="danger" @click="deleteHandler()">delete</el-button>




				</el-row>
			</el-form>

			<!-- <div> -->
				<el-table class="tables"
					:stripe='true'
					:style='{"padding":"0","borderColor":"#c695ed #2adbcb #2adbcb #2adbcb","margin":"0 0 20px","borderRadius":"0px","borderWidth":"4px 1px 1px 1px","background":"none","width":"100%","borderStyle":"solid dashed dashed dashed","order":"4"}'
					v-if="isAuth('yuyuelianxi','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='false' label="id" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='false'
						prop="jiaolianzhanghao"
					label="Coach account">
						<template slot-scope="scope">
							{{scope.row.jiaolianzhanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="jiaolianxingming"
					label="Coach Name">
						<template slot-scope="scope">
							{{scope.row.jiaolianxingming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="lianxidianhua"
					label="Contact Number">
						<template slot-scope="scope">
							{{scope.row.lianxidianhua}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="xueyuanzhanghao"
					label="Student account">
						<template slot-scope="scope">
							{{scope.row.xueyuanzhanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="xueyuanxingming"
					label="Student name">
						<template slot-scope="scope">
							{{scope.row.xueyuanxingming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="xueyuanshouji"
					label="Student mobile phone">
						<template slot-scope="scope">
							{{scope.row.xueyuanshouji}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="yuyueshijian"
					label="time of appointment">
						<template slot-scope="scope">
							{{scope.row.yuyueshijian}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="yuyuebeizhu"
					label="Appointment remarks">
						<template slot-scope="scope">
							{{scope.row.yuyuebeizhu}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'
						prop="lianxikemu"
					label="Practice subjects">
						<template slot-scope="scope">
							{{scope.row.lianxikemu}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false' prop="shhf" label="Review reply"></el-table-column>
					<el-table-column :resizable='true' :sortable='false' prop="sfsh" label="Audit status">
						<template slot-scope="scope">
							<span style="margin-right:10px" v-if="scope.row.sfsh=='是'">通过</span>
							<span style="margin-right:10px" v-if="scope.row.sfsh=='否'">未通过</span>
							<span style="margin-right:10px" v-if="scope.row.sfsh=='待审核'">待审核</span>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false' v-if="isAuth('yuyuelianxi','审核')" prop="sfsh" label="审核">
						<template slot-scope="scope">
							<el-button  type="text" size="small" @click="shDialog(scope.row)">审核</el-button>
						</template>
					</el-table-column>
					<el-table-column width="300" label="operate">
						<template slot-scope="scope">
							<el-button :style='{"border":"1px solid #a347ea","cursor":"pointer","padding":"0 16px","margin":"3px 6px 3px 0","outline":"none","color":"#a347ea","borderRadius":"20px","background":"#f3eafa","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('yuyuelianxi','查看')" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">info</el-button>
							<el-button :style='{"border":"1px solid #a347ea","cursor":"pointer","padding":"0 16px","margin":"3px 6px 3px 0","outline":"none","color":"#a347ea","borderRadius":"20px","background":"#f3eafa","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('yuyuelianxi','coach evaluate')" type="success" size="mini" @click="jiaolianpingjiaCrossAddOrUpdateHandler(scope.row,'cross','是','','')">coach evaluate</el-button>
							<el-button :style='{"border":"1px solid #1fbfae","cursor":"pointer","padding":"0 16px","margin":"3px 6px 3px 0","outline":"none","color":"#1fbfae","borderRadius":"20px","background":"#e9faf8","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('yuyuelianxi','modify')" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">modify</el-button>





							<el-button :style='{"border":"1px solid #dc333b","cursor":"pointer","padding":"0 16px","margin":"3px 6px 3px 0","outline":"none","color":"#dc333b","borderRadius":"20px","background":"#fbeced","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('yuyuelianxi','delete') " type="danger" size="mini" @click="deleteHandler(scope.row.id)">delete</el-button>
						</template>
					</el-table-column>
				</el-table>
				<el-pagination
					@size-change="sizeChangeHandle"
					@current-change="currentChangeHandle"
					:current-page="pageIndex"
					background
					:page-sizes="[10, 20, 30, 50]"
					:page-size="pageSize"
					:layout="layouts.join()"
					:total="totalPage"
					prev-text="<"
					next-text=">"
					:hide-on-single-page="true"
					:style='{"padding":"8px 10px","margin":"20px 0 0","borderColor":"#2adbcb","whiteSpace":"nowrap","color":"#b35ff3","background":"#fff","borderWidth":"4px","width":"100%","lineHeight":"54px","borderStyle":"dotted dashed solid double","fontWeight":"500","order":"5","height":"54px"}'
				></el-pagination>
			<!-- </div> -->
		</template>

		<!-- 添加/modify页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

		<jiaolianpingjia-cross-add-or-update v-if="jiaolianpingjiaCrossAddOrUpdateFlag" :parent="this" ref="jiaolianpingjiaCrossaddOrUpdate"></jiaolianpingjia-cross-add-or-update>

		<el-dialog title="审核" :visible.sync="sfshVisiable" width="50%">
			<el-form ref="form" :model="form" label-width="80px">
				<el-form-item label="Audit status">
					<el-select v-model="shForm.sfsh" placeholder="Audit status">
						<el-option label="通过" value="是"></el-option>
						<el-option label="不通过" value="否"></el-option>
						<el-option label="待审核" value="待审核"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="内容">
					<el-input type="textarea" :rows="8" v-model="shForm.shhf"></el-input>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer">
				<el-button @click="shDialog">Cancel</el-button>
				<el-button type="primary" @click="shHandler">确 定</el-button>
			</span>
		</el-dialog>



	</div>
</template>

<script>
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
import jiaolianpingjiaCrossAddOrUpdate from "../jiaolianpingjia/add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form:{},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      chartVisiable1: false,
      chartVisiable2: false,
      chartVisiable3: false,
      chartVisiable4: false,
      chartVisiable5: false,
      addOrUpdateFlag:false,
      jiaolianpingjiaCrossAddOrUpdateFlag: false,
      layouts: ["total","prev","pager","next","sizes","jumper"],

    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
    jiaolianpingjiaCrossAddOrUpdate,
  },
  methods: {

    contentStyleChange() {
      this.contentPageStyleChange()
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      // if(this.contents.pageTotal) arr.push('total')
      // if(this.contents.pageSizes) arr.push('sizes')
      // if(this.contents.pagePrevNext){
      //   arr.push('prev')
      //   if(this.contents.pagePager) arr.push('pager')
      //   arr.push('next')
      // }
      // if(this.contents.pageJumper) arr.push('jumper')
      // this.layouts = arr.join()
      // this.contents.pageEachNum = 10
    },

    jiaolianpingjiaCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
	if(crossOptAudit=='是'&&row.sfsh!='是') {
	    this.$message({
	      message: "Please review and approve before proceeding operate",
	      type: "success",
	      duration: 1500,
	      onClose: () => {
	      }
	    });
		return
	}
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.jiaolianpingjiaCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','yuyuelianxi');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.jiaolianpingjiaCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.jiaolianpingjiaCrossaddOrUpdate.init(row.id,type);
      });
    },







    init () {
        this.sfshOptions = "是,否,待审核".split(',');
          this.lianxikemuOptions = "科目二,科目三".split(',')
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
           if(this.searchForm.jiaolianzhanghao!='' && this.searchForm.jiaolianzhanghao!=undefined){
            params['jiaolianzhanghao'] = '%' + this.searchForm.jiaolianzhanghao + '%'
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
           if(this.searchForm.xueyuanzhanghao!='' && this.searchForm.xueyuanzhanghao!=undefined){
            params['xueyuanzhanghao'] = '%' + this.searchForm.xueyuanzhanghao + '%'
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
           if(this.searchForm.lianxikemu!='' && this.searchForm.lianxikemu!=undefined){
            params['lianxikemu'] = this.searchForm.lianxikemu
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
      this.$http({
        url: "yuyuelianxi/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/modify
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 审核窗口
    shDialog(row){
      this.sfshVisiable = !this.sfshVisiable;
      if(row){
        this.shForm = {
          jiaolianzhanghao: row.jiaolianzhanghao,
          jiaolianxingming: row.jiaolianxingming,
          lianxidianhua: row.lianxidianhua,
          xueyuanzhanghao: row.xueyuanzhanghao,
          xueyuanxingming: row.xueyuanxingming,
          xueyuanshouji: row.xueyuanshouji,
          yuyueshijian: row.yuyueshijian,
          yuyuebeizhu: row.yuyuebeizhu,
          lianxikemu: row.lianxikemu,
          sfsh: row.sfsh,
          shhf: row.shhf,
          id: row.id
        }
      }
    },
    // 审核
    shHandler(){
      this.$confirm(`sureoperate?`, "prompt", {
        confirmButtonText: "sure",
        cancelButtonText: "cancel",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "yuyuelianxi/update",
          method: "post",
          data: this.shForm
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "operate success",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.getDataList();
                this.shDialog()
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // delete
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`sure perform[${id ? "delete" : " batch delete"}]operate?`, "prompt", {
        confirmButtonText: "sure",
        cancelButtonText: "cancel",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "yuyuelianxi/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "operate success",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


  }

};
</script>
<style lang="scss" scoped>

	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}

	.el-input {
	  width: auto;
	}

	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border: 0px solid #fbcc0f;
				border-radius: 0;
				padding: 0 20px;
				box-shadow: 2px 3px 2px #ccc;
				outline: none;
				color: #999;
				background: url(http://codegen.caihongy.cn/20221130/b1773df61c064cc8933eefc9217e387b.png) no-repeat;
				width: 191px;
				font-size: 14px;
				height: 44px;
			}

	.center-form-pv .el-select /deep/ .el-input__inner {
				border: 0px solid #fbcc0f;
				border-radius: 0px;
				padding: 0 20px;
				box-shadow: 2px 3px 2px #ccc;
				outline: none;
				color: #999;
				background: url(http://codegen.caihongy.cn/20221130/b1773df61c064cc8933eefc9217e387b.png) no-repeat;
				width: 191px;
				font-size: 14px;
				height: 44px;
			}

	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border: 0px solid #fbcc0f;
				border-radius: 0px;
				padding: 0 10px 0 30px;
				box-shadow: 2px 3px 2px #ccc;
				outline: none;
				color: #999;
				background: url(http://codegen.caihongy.cn/20221130/b1773df61c064cc8933eefc9217e387b.png) no-repeat;
				width: 191px;
				font-size: 14px;
				height: 44px;
			}

	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				color: #999;
				font-weight: 500;
				width: 100%;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: #fff;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 10px;
				color: #fff;
				background: linear-gradient(349deg, rgba(42,219,203,1) 0%, rgba(152,122,222,1) 100%);
				border-color: #2adbcb;
				border-width: 0 0px 1px 0;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: bold;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}


	.el-table /deep/ .el-table__body-wrapper tbody {
				border: 0;
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				border: 0;
				background: none;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #666;
				background: none;
				border-color: #2adbcb;
				border-width: 0 1px 1px 0;
				border-style: dashed;
				text-align: left;
			}

		.el-table /deep/ .el-table__body-wrapper tbody tr.el-table__row--striped td {
		background: rgba(223,246,244,.6);
	}

	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 12px 0;
				color: #9531e2;
				background: #f2eff9;
				border-color: #2adbcb;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #666;
				background: none;
				border-color: #2adbcb;
				border-width: 0 1px 1px 0;
				border-style: dashed;
				text-align: left;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}

	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: #999;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
			}

	.main-content .el-pagination /deep/ .btn-prev {
				border: 1px solid #999;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #999;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				min-width: 35px;
			}

	.main-content .el-pagination /deep/ .btn-next {
				border: 1px solid #999;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #999;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				line-height: 28px;
				min-width: 35px;
			}

	.main-content .el-pagination /deep/ .btn-prev:disabled {
				border: 1px solid #999;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #999;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
			}

	.main-content .el-pagination /deep/ .btn-next:disabled {
				border: 1px solid #999;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #999;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
			}

	.main-content .el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				border: 1px solid #999;
				border-radius: 2px;
				padding: 0 4px;
				margin: 0 5px;
				color: #999;
				background: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				text-align: center;
				min-width: 30px;
			}

	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				border: 0;
				border-radius: 2px;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				background: linear-gradient(349deg, rgba(42,219,203,1) 0%, rgba(152,122,222,1) 100%);
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				text-align: center;
				min-width: 30px;
			}

	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				border-radius: 2px;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				background: linear-gradient(349deg, rgba(42,219,203,1) 0%, rgba(152,122,222,1) 100%);
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				text-align: center;
				min-width: 30px;
			}

	.main-content .el-pagination /deep/ .el-pagination__sizes {
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
			}

	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				width: 100px;
				position: relative;
			}

	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 1px solid #999;
				cursor: pointer;
				border-radius: 3px;
				padding: 0 25px 0 8px;
				outline: 0;
				color: #999;
				background: #FFF;
				display: inline-block;
				width: 100%;
				font-size: 13px;
				text-align: center;
			}

	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}

	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #999;
				width: 25px;
				font-size: 14px;
				text-align: center;
			}

	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: #999;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
			}

	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				display: inline-block;
				width: 50px;
				font-size: 14px;
				position: relative;
				text-align: center;
			}

	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #999;
				cursor: pointer;
				border-radius: 3px;
				padding: 0 3px;
				outline: 0;
				color: #999;
				background: #FFF;
				display: inline-block;
				width: 100%;
				font-size: 14px;
				text-align: center;
			}
</style>
