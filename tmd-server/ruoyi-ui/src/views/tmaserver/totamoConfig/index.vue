<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="配置id" prop="configId">
        <el-input
          v-model="queryParams.configId"
          placeholder="请输入配置id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专注时间定时" prop="timerFocus">
        <el-input
          v-model="queryParams.timerFocus"
          placeholder="请输入专注时间定时"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="短休息时间定时" prop="timerShortBreak">
        <el-input
          v-model="queryParams.timerShortBreak"
          placeholder="请输入短休息时间定时"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="长休息时间定时" prop="timerLongBreak">
        <el-input
          v-model="queryParams.timerLongBreak"
          placeholder="请输入长休息时间定时"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="每组包含番茄数" prop="timerRounds">
        <el-input
          v-model="queryParams.timerRounds"
          placeholder="请输入每组包含番茄数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户id"
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
          v-hasPermi="['tmaserver:totamoConfig:add']"
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
          v-hasPermi="['tmaserver:totamoConfig:edit']"
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
          v-hasPermi="['tmaserver:totamoConfig:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['tmaserver:totamoConfig:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="totamoConfigList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" v-if="true"/>
      <el-table-column label="配置id" align="center" prop="configId" />
      <el-table-column label="专注时间定时" align="center" prop="timerFocus" />
      <el-table-column label="短休息时间定时" align="center" prop="timerShortBreak" />
      <el-table-column label="长休息时间定时" align="center" prop="timerLongBreak" />
      <el-table-column label="每组包含番茄数" align="center" prop="timerRounds" />
      <el-table-column label="用户id" align="center" prop="userId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['tmaserver:totamoConfig:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['tmaserver:totamoConfig:remove']"
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

    <!-- 添加或修改番茄配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="配置id" prop="configId">
          <el-input v-model="form.configId" placeholder="请输入配置id" />
        </el-form-item>
        <el-form-item label="专注时间定时" prop="timerFocus">
          <el-input v-model="form.timerFocus" placeholder="请输入专注时间定时" />
        </el-form-item>
        <el-form-item label="短休息时间定时" prop="timerShortBreak">
          <el-input v-model="form.timerShortBreak" placeholder="请输入短休息时间定时" />
        </el-form-item>
        <el-form-item label="长休息时间定时" prop="timerLongBreak">
          <el-input v-model="form.timerLongBreak" placeholder="请输入长休息时间定时" />
        </el-form-item>
        <el-form-item label="每组包含番茄数" prop="timerRounds">
          <el-input v-model="form.timerRounds" placeholder="请输入每组包含番茄数" />
        </el-form-item>
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户id" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTotamoConfig, getTotamoConfig, delTotamoConfig, addTotamoConfig, updateTotamoConfig } from "@/api/tmaserver/totamoConfig";

export default {
  name: "TotamoConfig",
  data() {
    return {
      // 按钮loading
      buttonLoading: false,
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
      // 番茄配置表格数据
      totamoConfigList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        configId: undefined,
        timerFocus: undefined,
        timerShortBreak: undefined,
        timerLongBreak: undefined,
        timerRounds: undefined,
        userId: undefined
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [
          { required: true, message: "主键不能为空", trigger: "blur" }
        ],
        configId: [
          { required: true, message: "配置id不能为空", trigger: "blur" }
        ],
        timerFocus: [
          { required: true, message: "专注时间定时不能为空", trigger: "blur" }
        ],
        timerShortBreak: [
          { required: true, message: "短休息时间定时不能为空", trigger: "blur" }
        ],
        timerLongBreak: [
          { required: true, message: "长休息时间定时不能为空", trigger: "blur" }
        ],
        timerRounds: [
          { required: true, message: "每组包含番茄数不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "用户id不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询番茄配置列表 */
    getList() {
      this.loading = true;
      listTotamoConfig(this.queryParams).then(response => {
        this.totamoConfigList = response.rows;
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
        id: undefined,
        version: undefined,
        createBy: undefined,
        createTime: undefined,
        updateBy: undefined,
        updateTime: undefined,
        configId: undefined,
        timerFocus: undefined,
        timerShortBreak: undefined,
        timerLongBreak: undefined,
        timerRounds: undefined,
        userId: undefined
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
      this.title = "添加番茄配置";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.loading = true;
      this.reset();
      const id = row.id || this.ids
      getTotamoConfig(id).then(response => {
        this.loading = false;
        this.form = response.data;
        this.open = true;
        this.title = "修改番茄配置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.buttonLoading = true;
          if (this.form.id != null) {
            updateTotamoConfig(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          } else {
            addTotamoConfig(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除番茄配置编号为"' + ids + '"的数据项？').then(() => {
        this.loading = true;
        return delTotamoConfig(ids);
      }).then(() => {
        this.loading = false;
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      }).finally(() => {
        this.loading = false;
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('tmaserver/totamoConfig/export', {
        ...this.queryParams
      }, `totamoConfig_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
