<template>
	<div class="navbar">
		<div class="title" :style='{"width":"1200px","padding":"0 20px","margin":"0 auto","textAlign":"center","background":"none","display":"block"}'>
			<el-image v-if="false" class="title-img" :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","float":"left","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover" />
			<span class="title-name" :style='{"padding":"0","lineHeight":"64px","fontSize":"20px","color":"#fff"}'>{{this.$project.projectName}}</span>
		</div>
		<div class="right" :style='{"top":"10px","textAlign":"right","background":"none","display":"flex","position":"absolute","right":"200px","float":"right"}'>
			<div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#fff"}' class="nickname">{{this.$storage.get('role')}} {{this.$storage.get('adminName')}}</div>
			<div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#fff"}' v-if="this.$storage.get('role')!='admin'" class="logout" @click="onIndexTap">Exit to the front desk</div>
			<div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#fff"}' class="logout" @click="onLogout">Log Out</div>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				dialogVisible: false,
				ruleForm: {},
				user: {},
			};
		},
		created() {

		},
		mounted() {
			let sessionTable = this.$storage.get("sessionTable")
			this.$http({
				url: sessionTable + '/session',
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
					this.user = data.data;
					this.$storage.set('userid',data.data.id);
				} else {
					let message = this.$message
					message.error(data.msg);
				}
			});
		},
		methods: {
			onLogout() {
				let storage = this.$storage
				let router = this.$router
				storage.clear()
				router.replace({
					name: "login"
				});
			},
			onIndexTap(){
				window.location.href = `${this.$base.indexUrl}`
			},
		}
	};
</script>


<style lang="scss" scoped>
	.navbar {

	}
</style>
