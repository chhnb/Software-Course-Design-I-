"use strict";(self["webpackChunkuntitled1"]=self["webpackChunkuntitled1"]||[]).push([[771],{5771:function(e,r,t){t.r(r),t.d(r,{default:function(){return b}});var a=t(3396),l=t(2311);const s=e=>((0,a.dD)("data-v-57866150"),e=e(),(0,a.Cn)(),e),o=s((()=>(0,a._)("p",{class:"title"},"修 改 用 户 名",-1))),u=s((()=>(0,a._)("div",{class:"logo"},[(0,a._)("img",{class:"image",src:l})],-1))),m=s((()=>(0,a._)("br",null,null,-1))),n=s((()=>(0,a._)("br",null,null,-1))),d=s((()=>(0,a._)("br",null,null,-1))),i=(0,a.Uk)("提交");function c(e,r,t,l,s,c){const g=(0,a.up)("el-divider"),p=(0,a.up)("el-input"),w=(0,a.up)("el-form-item"),f=(0,a.up)("el-button"),h=(0,a.up)("el-form");return(0,a.wg)(),(0,a.iD)(a.HY,null,[(0,a.Wm)(g,{class:"divide1"}),o,(0,a.Wm)(g,{class:"divide2"}),u,m,n,(0,a.Wm)(h,{model:s.ruleForm,rules:s.rules,ref:"ruleForm","label-width":"100px",class:"demo-ruleForm"},{default:(0,a.w5)((()=>[(0,a.Wm)(w,{label:"新用户名",prop:"userName",class:"name"},{default:(0,a.w5)((()=>[(0,a.Wm)(p,{modelValue:s.ruleForm.userName,"onUpdate:modelValue":r[0]||(r[0]=e=>s.ruleForm.userName=e)},null,8,["modelValue"])])),_:1}),d,(0,a.Wm)(w,{class:"button"},{default:(0,a.w5)((()=>[(0,a.Wm)(f,{type:"primary",onClick:r[1]||(r[1]=e=>c.submitForm("ruleForm")),class:"submit"},{default:(0,a.w5)((()=>[i])),_:1})])),_:1})])),_:1},8,["model","rules"])],64)}t(7658);var g=t(6265),p=t.n(g);p().defaults.headers.common.token=window.localStorage.getItem("token"),p().defaults.headers.post["Content-Type"]="application/json;charset=UTF-8";var w={name:"newName",data(){return{ruleForm:{userName:""},rules:{userName:[{required:!0,message:"请输入您的名称",trigger:"blur"},{min:4,max:16,message:"长度在 4 到 16 个字符",trigger:"blur"}]}}},methods:{submitForm(e){this.$refs[e].validate((e=>{if(!e)return console.log("error submit!!"),!1;console.log(this.$data.ruleForm.userName),p().post("/changeUserName",{token:window.localStorage.getItem("token"),userName:this.$data.ruleForm.userName}).then((e=>{console.log(e.data),0===e.data.code?(this.$message({type:"success",message:"修改成功"}),window.localStorage.setItem("userName",this.ruleForm.userName),window.localStorage.setItem("token",e.data.token)):(this.$message({type:"error",message:e.data.message}),"50000"===e.data.code&&(window.localStorage.removeItem("token"),this.$router.push("/")))}))}))}}},f=t(89);const h=(0,f.Z)(w,[["render",c],["__scopeId","data-v-57866150"]]);var b=h},2311:function(e,r,t){e.exports=t.p+"img/repair_logo.6db0530d.png"}}]);
//# sourceMappingURL=771.38fafba1.js.map