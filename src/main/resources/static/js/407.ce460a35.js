"use strict";(self["webpackChunkuntitled1"]=self["webpackChunkuntitled1"]||[]).push([[407],{6407:function(e,a,r){r.r(a),r.d(a,{default:function(){return h}});var t=r(3396),l=r(2311);const s=e=>((0,t.dD)("data-v-509a13ba"),e=e(),(0,t.Cn)(),e),o=s((()=>(0,t._)("p",{class:"title"},"修 改 用 户 名",-1))),u=s((()=>(0,t._)("div",{class:"logo"},[(0,t._)("img",{class:"image",src:l})],-1))),m=s((()=>(0,t._)("br",null,null,-1))),n=s((()=>(0,t._)("br",null,null,-1))),d=s((()=>(0,t._)("br",null,null,-1))),i=(0,t.Uk)("提交");function c(e,a,r,l,s,c){const g=(0,t.up)("el-divider"),p=(0,t.up)("el-input"),w=(0,t.up)("el-form-item"),b=(0,t.up)("el-button"),f=(0,t.up)("el-form");return(0,t.wg)(),(0,t.iD)(t.HY,null,[(0,t.Wm)(g,{class:"divide1"}),o,(0,t.Wm)(g,{class:"divide2"}),u,m,n,(0,t.Wm)(f,{model:s.ruleForm,rules:s.rules,ref:"ruleForm","label-width":"100px",class:"demo-ruleForm"},{default:(0,t.w5)((()=>[(0,t.Wm)(w,{label:"新用户名",prop:"userName",class:"name"},{default:(0,t.w5)((()=>[(0,t.Wm)(p,{modelValue:s.ruleForm.userName,"onUpdate:modelValue":a[0]||(a[0]=e=>s.ruleForm.userName=e)},null,8,["modelValue"])])),_:1}),d,(0,t.Wm)(w,{class:"button"},{default:(0,t.w5)((()=>[(0,t.Wm)(b,{type:"primary",onClick:a[1]||(a[1]=e=>c.submitForm("ruleForm")),class:"submit"},{default:(0,t.w5)((()=>[i])),_:1})])),_:1})])),_:1},8,["model","rules"])],64)}r(7658);var g=r(6265),p=r.n(g);p().defaults.headers.common.token=window.localStorage.getItem("token"),p().defaults.headers.post["Content-Type"]="application/json;charset=UTF-8";var w={name:"newName",data(){return{ruleForm:{userName:""},rules:{userName:[{required:!0,message:"请输入您的名称",trigger:"blur"},{min:4,max:16,message:"长度在 4 到 16 个字符",trigger:"blur"}]}}},methods:{submitForm(e){this.$refs[e].validate((e=>{if(!e)return console.log("error submit!!"),!1;console.log(this.$data.ruleForm.userName),p().post("/changeUserName",{token:window.localStorage.getItem("token"),userName:this.$data.ruleForm.userName}).then((e=>{console.log(e.data),0===e.data.code?(this.$message({type:"success",message:"修改成功"}),window.localStorage.setItem("userName",this.ruleForm.userName),window.localStorage.setItem("token",e.data.token)):(this.$message({type:"error",message:e.data.message}),"50000"===e.data.code&&(window.localStorage.removeItem("token"),this.$router.push("/")))}))}))}}},b=r(89);const f=(0,b.Z)(w,[["render",c],["__scopeId","data-v-509a13ba"]]);var h=f},2311:function(e,a,r){e.exports=r.p+"img/repair_logo.6db0530d.png"}}]);
//# sourceMappingURL=407.ce460a35.js.map