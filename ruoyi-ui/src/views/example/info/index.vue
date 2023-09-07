<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="指令编码" prop="instructionCode">
        <el-input
          v-model="queryParams.instructionCode"
          placeholder="请输入指令编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="指令标题" prop="instructionTitle">
        <el-input
          v-model="queryParams.instructionTitle"
          placeholder="请输入指令标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="办理期限" prop="handleTime">
        <el-date-picker clearable
          v-model="queryParams.handleTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择办理期限">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="接收单位" prop="receiveUnit">
        <el-input
          v-model="queryParams.receiveUnit"
          placeholder="请输入接收单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="紧急程度" prop="emergencyDegree">
        <el-input
          v-model="queryParams.emergencyDegree"
          placeholder="请输入紧急程度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="关联群体id" prop="groupId">
        <el-input
          v-model="queryParams.groupId"
          placeholder="请输入关联群体id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="信息来源" prop="sourceInfo">
        <el-input
          v-model="queryParams.sourceInfo"
          placeholder="请输入信息来源"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建者" prop="creatorBy">
        <el-input
          v-model="queryParams.creatorBy"
          placeholder="请输入创建者"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="反馈要求" prop="feedback">
        <el-input
          v-model="queryParams.feedback"
          placeholder="请输入反馈要求"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="人员ids" prop="personIds">
        <el-input
          v-model="queryParams.personIds"
          placeholder="请输入人员ids"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="指令创建者部门id" prop="createDeptId">
        <el-input
          v-model="queryParams.createDeptId"
          placeholder="请输入指令创建者部门id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="牵头人员id" prop="leadPersonIds">
        <el-input
          v-model="queryParams.leadPersonIds"
          placeholder="请输入牵头人员id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="推送时间" prop="pushTime">
        <el-date-picker clearable
          v-model="queryParams.pushTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择推送时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="信息类别" prop="infoCategory">
        <el-input
          v-model="queryParams.infoCategory"
          placeholder="请输入信息类别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['example:info:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['example:info:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['example:info:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['example:info:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="指令主键" align="center" prop="id" />
      <el-table-column label="指令编码" align="center" prop="instructionCode" />
      <el-table-column label="指令标题" align="center" prop="instructionTitle" />
      <el-table-column label="办理期限" align="center" prop="handleTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.handleTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="接收单位" align="center" prop="receiveUnit" />
      <el-table-column label="紧急程度" align="center" prop="emergencyDegree" />
      <el-table-column label="关联群体id" align="center" prop="groupId" />
      <el-table-column label="事件类型" align="center" prop="type" />
      <el-table-column label="信息来源" align="center" prop="sourceInfo" />
      <el-table-column label="指令内容" align="center" prop="instructionContent" />
      <el-table-column label="基本情况" align="center" prop="baseInfo" />
      <el-table-column label="创建者" align="center" prop="creatorBy" />
      <el-table-column label="状态 1:正常  9：删除" align="center" prop="status" />
      <el-table-column label="指令状态 1:交办 2:暂存" align="center" prop="instructionStatus" />
      <el-table-column label="反馈要求" align="center" prop="feedback" />
      <el-table-column label="人员ids" align="center" prop="personIds" />
      <el-table-column label="指令创建者部门id" align="center" prop="createDeptId" />
      <el-table-column label="牵头人员id" align="center" prop="leadPersonIds" />
      <el-table-column label="上访类型1：到市 2：赴省 3：进京" align="center" prop="petitionType" />
      <el-table-column label="推送时间" align="center" prop="pushTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.pushTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="信息类别" align="center" prop="infoCategory" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['example:info:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['example:info:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改指令基本信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="指令编码" prop="instructionCode">
          <el-input v-model="form.instructionCode" placeholder="请输入指令编码" />
        </el-form-item>
        <el-form-item label="指令标题" prop="instructionTitle">
          <el-input v-model="form.instructionTitle" placeholder="请输入指令标题" />
        </el-form-item>
        <el-form-item label="办理期限" prop="handleTime">
          <el-date-picker clearable
            v-model="form.handleTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择办理期限">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="接收单位" prop="receiveUnit">
          <el-input v-model="form.receiveUnit" placeholder="请输入接收单位" />
        </el-form-item>
        <el-form-item label="紧急程度" prop="emergencyDegree">
          <el-input v-model="form.emergencyDegree" placeholder="请输入紧急程度" />
        </el-form-item>
        <el-form-item label="关联群体id" prop="groupId">
          <el-input v-model="form.groupId" placeholder="请输入关联群体id" />
        </el-form-item>
        <el-form-item label="信息来源" prop="sourceInfo">
          <el-input v-model="form.sourceInfo" placeholder="请输入信息来源" />
        </el-form-item>
        <el-form-item label="指令内容">
          <editor v-model="form.instructionContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="基本情况" prop="baseInfo">
          <el-input v-model="form.baseInfo" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="创建者" prop="creatorBy">
          <el-input v-model="form.creatorBy" placeholder="请输入创建者" />
        </el-form-item>
        <el-form-item label="反馈要求" prop="feedback">
          <el-input v-model="form.feedback" placeholder="请输入反馈要求" />
        </el-form-item>
        <el-form-item label="人员ids" prop="personIds">
          <el-input v-model="form.personIds" placeholder="请输入人员ids" />
        </el-form-item>
        <el-form-item label="指令创建者部门id" prop="createDeptId">
          <el-input v-model="form.createDeptId" placeholder="请输入指令创建者部门id" />
        </el-form-item>
        <el-form-item label="牵头人员id" prop="leadPersonIds">
          <el-input v-model="form.leadPersonIds" placeholder="请输入牵头人员id" />
        </el-form-item>
        <el-form-item label="推送时间" prop="pushTime">
          <el-date-picker clearable
            v-model="form.pushTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择推送时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="信息类别" prop="infoCategory">
          <el-input v-model="form.infoCategory" placeholder="请输入信息类别" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listInfo, getInfo, delInfo, addInfo, updateInfo } from "@/api/example/info";

export default {
  name: "Info",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 指令基本信息表格数据
      infoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        instructionCode: null,
        instructionTitle: null,
        handleTime: null,
        receiveUnit: null,
        emergencyDegree: null,
        groupId: null,
        type: null,
        sourceInfo: null,
        instructionContent: null,
        baseInfo: null,
        creatorBy: null,
        status: null,
        instructionStatus: null,
        feedback: null,
        personIds: null,
        createDeptId: null,
        leadPersonIds: null,
        petitionType: null,
        pushTime: null,
        infoCategory: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询指令基本信息列表 */
    getList() {
      this.loading = true;
      listInfo(this.queryParams).then(response => {
        this.infoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        instructionCode: null,
        instructionTitle: null,
        handleTime: null,
        receiveUnit: null,
        emergencyDegree: null,
        groupId: null,
        type: null,
        sourceInfo: null,
        instructionContent: null,
        baseInfo: null,
        createTime: null,
        creatorBy: null,
        updateTime: null,
        status: null,
        instructionStatus: null,
        feedback: null,
        personIds: null,
        createDeptId: null,
        leadPersonIds: null,
        petitionType: null,
        pushTime: null,
        infoCategory: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加指令基本信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改指令基本信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInfo(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除指令基本信息编号为"' + ids + '"的数据项？').then(function() {
        return delInfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('example/info/export', {
        ...this.queryParams
      }, `info_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
