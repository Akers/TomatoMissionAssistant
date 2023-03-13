<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="番茄组ID" prop="groupId">
        <el-input
          v-model="queryParams.groupId"
          placeholder="请输入番茄组ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实际消耗专注时长;专注工作时间" prop="focusTime">
        <el-input
          v-model="queryParams.focusTime"
          placeholder="请输入实际消耗专注时长;专注工作时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="在番茄组中的排序" prop="sort">
        <el-input
          v-model="queryParams.sort"
          placeholder="请输入在番茄组中的排序"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实际休息时长" prop="breakTime">
        <el-input
          v-model="queryParams.breakTime"
          placeholder="请输入实际休息时长"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务ID" prop="missionId">
        <el-input
          v-model="queryParams.missionId"
          placeholder="请输入任务ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="番茄配置ID" prop="tomatoConfigId">
        <el-input
          v-model="queryParams.tomatoConfigId"
          placeholder="请输入番茄配置ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="配置的专注工作时间" prop="focusTimeCofniged">
        <el-input
          v-model="queryParams.focusTimeCofniged"
          placeholder="请输入配置的专注工作时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="配置的休息时长" prop="breakTimeConfiged">
        <el-input
          v-model="queryParams.breakTimeConfiged"
          placeholder="请输入配置的休息时长"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否组组里的最后一轮" prop="isLast">
        <el-input
          v-model="queryParams.isLast"
          placeholder="请输入是否组组里的最后一轮"
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
          v-hasPermi="['tmaserver:tomato:add']"
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
          v-hasPermi="['tmaserver:tomato:edit']"
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
          v-hasPermi="['tmaserver:tomato:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['tmaserver:tomato:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tomatoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" v-if="true"/>
      <el-table-column label="番茄组ID" align="center" prop="groupId" />
      <el-table-column label="用户ID" align="center" prop="userId" />
      <el-table-column label="实际消耗专注时长;专注工作时间" align="center" prop="focusTime" />
      <el-table-column label="在番茄组中的排序" align="center" prop="sort" />
      <el-table-column label="实际休息时长" align="center" prop="breakTime" />
      <el-table-column label="任务ID" align="center" prop="missionId" />
      <el-table-column label="休息类型;1--短休息；2--长休息" align="center" prop="breakType" />
      <el-table-column label="番茄配置ID" align="center" prop="tomatoConfigId" />
      <el-table-column label="配置的专注工作时间" align="center" prop="focusTimeCofniged" />
      <el-table-column label="配置的休息时长" align="center" prop="breakTimeConfiged" />
      <el-table-column label="是否组组里的最后一轮" align="center" prop="isLast" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['tmaserver:tomato:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['tmaserver:tomato:remove']"
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

    <!-- 添加或修改番茄计时对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="番茄组ID" prop="groupId">
          <el-input v-model="form.groupId" placeholder="请输入番茄组ID" />
        </el-form-item>
        <el-form-item label="用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="实际消耗专注时长;专注工作时间" prop="focusTime">
          <el-input v-model="form.focusTime" placeholder="请输入实际消耗专注时长;专注工作时间" />
        </el-form-item>
        <el-form-item label="在番茄组中的排序" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入在番茄组中的排序" />
        </el-form-item>
        <el-form-item label="实际休息时长" prop="breakTime">
          <el-input v-model="form.breakTime" placeholder="请输入实际休息时长" />
        </el-form-item>
        <el-form-item label="任务ID" prop="missionId">
          <el-input v-model="form.missionId" placeholder="请输入任务ID" />
        </el-form-item>
        <el-form-item label="番茄配置ID" prop="tomatoConfigId">
          <el-input v-model="form.tomatoConfigId" placeholder="请输入番茄配置ID" />
        </el-form-item>
        <el-form-item label="配置的专注工作时间" prop="focusTimeCofniged">
          <el-input v-model="form.focusTimeCofniged" placeholder="请输入配置的专注工作时间" />
        </el-form-item>
        <el-form-item label="配置的休息时长" prop="breakTimeConfiged">
          <el-input v-model="form.breakTimeConfiged" placeholder="请输入配置的休息时长" />
        </el-form-item>
        <el-form-item label="是否组组里的最后一轮" prop="isLast">
          <el-input v-model="form.isLast" placeholder="请输入是否组组里的最后一轮" />
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
import { listTomato, getTomato, delTomato, addTomato, updateTomato } from "@/api/tmaserver/tomato";

export default {
  name: "Tomato",
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
      // 番茄计时表格数据
      tomatoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        groupId: undefined,
        userId: undefined,
        focusTime: undefined,
        sort: undefined,
        breakTime: undefined,
        missionId: undefined,
        breakType: undefined,
        tomatoConfigId: undefined,
        focusTimeCofniged: undefined,
        breakTimeConfiged: undefined,
        isLast: undefined
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [
          { required: true, message: "主键不能为空", trigger: "blur" }
        ],
        groupId: [
          { required: true, message: "番茄组ID不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "用户ID不能为空", trigger: "blur" }
        ],
        focusTime: [
          { required: true, message: "实际消耗专注时长;专注工作时间不能为空", trigger: "blur" }
        ],
        sort: [
          { required: true, message: "在番茄组中的排序不能为空", trigger: "blur" }
        ],
        breakTime: [
          { required: true, message: "实际休息时长不能为空", trigger: "blur" }
        ],
        missionId: [
          { required: true, message: "任务ID不能为空", trigger: "blur" }
        ],
        breakType: [
          { required: true, message: "休息类型;1--短休息；2--长休息不能为空", trigger: "change" }
        ],
        tomatoConfigId: [
          { required: true, message: "番茄配置ID不能为空", trigger: "blur" }
        ],
        focusTimeCofniged: [
          { required: true, message: "配置的专注工作时间不能为空", trigger: "blur" }
        ],
        breakTimeConfiged: [
          { required: true, message: "配置的休息时长不能为空", trigger: "blur" }
        ],
        isLast: [
          { required: true, message: "是否组组里的最后一轮不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询番茄计时列表 */
    getList() {
      this.loading = true;
      listTomato(this.queryParams).then(response => {
        this.tomatoList = response.rows;
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
        groupId: undefined,
        userId: undefined,
        focusTime: undefined,
        sort: undefined,
        breakTime: undefined,
        missionId: undefined,
        breakType: undefined,
        tomatoConfigId: undefined,
        focusTimeCofniged: undefined,
        breakTimeConfiged: undefined,
        isLast: undefined
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
      this.title = "添加番茄计时";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.loading = true;
      this.reset();
      const id = row.id || this.ids
      getTomato(id).then(response => {
        this.loading = false;
        this.form = response.data;
        this.open = true;
        this.title = "修改番茄计时";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.buttonLoading = true;
          if (this.form.id != null) {
            updateTomato(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          } else {
            addTomato(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除番茄计时编号为"' + ids + '"的数据项？').then(() => {
        this.loading = true;
        return delTomato(ids);
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
      this.download('tmaserver/tomato/export', {
        ...this.queryParams
      }, `tomato_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
