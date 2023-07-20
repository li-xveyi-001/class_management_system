<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-col :span="4" :xs="24">
        <div class="head-container">
          <el-input
            v-model="deptName"
            placeholder="请输入班级名称"
            clearable
            prefix-icon="Search"
            style="margin-bottom: 20px"
          />
        </div>
        <div class="head-container">
          <el-tree
            :data="deptOptions"
            :props="{ label: 'label', children: 'children' }"
            :expand-on-click-node="false"
            :filter-node-method="filterNode"
            ref="deptTreeRef"
            node-key="id"
            highlight-current
            default-expand-all
            @node-click="handleNodeClick"
          />
        </div>
      </el-col>
      <el-col :span="20" :xs="24">
        <el-form
          :model="queryParams"
          ref="queryRef"
          :inline="true"
          v-show="showSearch"
          label-width="68px"
        >
          <el-row>
            <el-col :span="6">
              <el-form-item label="学生学号" prop="userNumber">
                <el-input
                  v-model="queryParams.userNumber"
                  placeholder="请输入学生学号"
                  clearable
                  @keyup.enter="handleQuery"
                />
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="学生姓名" prop="userName">
                <el-input
                  v-model="queryParams.userName"
                  placeholder="请输入学生姓名"
                  clearable
                  @keyup.enter="handleQuery"
                /> </el-form-item
            ></el-col>
            <el-col :span="6">
              <el-form-item label="综合排名" prop="overallRank">
                <el-input
                  v-model="queryParams.overallRank"
                  placeholder="请输入综合排名"
                  clearable
                  @keyup.enter="handleQuery"
                /> </el-form-item
            ></el-col>
            <el-col :span="6">
              <el-form-item label="学习排名" prop="learnRank">
                <el-input
                  v-model="queryParams.learnRank"
                  placeholder="请输入学习排名"
                  clearable
                  @keyup.enter="handleQuery"
                />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="量化排名" prop="quantificationRank">
                <el-input
                  v-model="queryParams.quantificationRank"
                  placeholder="请输入量化排名"
                  clearable
                  @keyup.enter="handleQuery"
                />
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="学期" prop="semesterName">
                <el-input
                  v-model="queryParams.semesterName"
                  placeholder="请输入学期"
                  clearable
                  @keyup.enter="handleQuery"
                />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item>
                <el-button
                  type="primary"
                  icon="search"
                  size="mini"
                  @click="handleQuery"
                  >搜索</el-button
                >

                <el-button icon="Refresh" size="mini" @click="resetQuery"
                  >重置</el-button
                >
              </el-form-item>
            </el-col>
            <el-col></el-col>
            <el-col></el-col>
          </el-row>

          <!-- <el-form-item label="班级ID" prop="classId">
        <el-input
          v-model="queryParams.classId"
          placeholder="请输入班级ID"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item> -->
        </el-form>

        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button
              type="primary"
              plain
              icon="Plus"
              size="mini"
              @click="handleAdd"
              v-hasPermi="['system:grade:add']"
              >新增</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              plain
              icon="Edit"
              size="mini"
              :disabled="single"
              @click="handleUpdate"
              v-hasPermi="['system:grade:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="danger"
              plain
              icon="Delete"
              size="mini"
              :disabled="multiple"
              @click="handleDelete"
              v-hasPermi="['system:grade:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="info"
              plain
              icon="Upload"
              @click="handleImport"
              v-hasPermi="['system:user:import']"
              >导入</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="warning"
              plain
              icon="Download"
              size="mini"
              @click="handleExport"
              v-hasPermi="['system:grade:export']"
              >导出</el-button
            >
          </el-col>
          <right-toolbar
            v-model:showSearch="showSearch"
            @queryTable="getList"
          ></right-toolbar>
        </el-row>

        <el-table
          v-loading="loading"
          :data="gradeList"
          @selection-change="handleSelectionChange"
        >
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" fixed="left">
            <template #default="{ $index }">
              {{
                $index + 1 + (queryParams.pageNum - 1) * queryParams.pageSize
              }}
            </template>
          </el-table-column>
          <el-table-column label="用户编号" align="center" prop="id"  />
          <el-table-column
            label="学生学号"
            align="center"
            prop="userNumber"
            width="120"
            :show-overflow-tooltip="true"
          />
          <el-table-column label="学生姓名" align="center" prop="userName" />
          <el-table-column label="综合排名" align="center" prop="overallRank" />
          <el-table-column
            label="综合分数"
            align="center"
            prop="overallScore"
          />
          <el-table-column label="学习排名" align="center" prop="learnRank" />
          <el-table-column label="学习分数" align="center" prop="learnScore" />
          <el-table-column
            label="量化排名"
            align="center"
            prop="quantificationRank"
          />
          <el-table-column
            label="量化分数"
            align="center"
            prop="quantificationScore"
          />
          <el-table-column label="班级" align="center" prop="deptName" />
          <el-table-column
            label="学期"
            align="center"
            prop="semesterName"
            width="150"
            :show-overflow-tooltip="true"
          />
          <el-table-column label="备注" align="center" prop="remark" />
          <el-table-column
            label="操作"
            align="center"
            class-name="small-padding fixed-width"
          >
            <template #default="scope">
              <el-tooltip
                content="修改"
                placement="top"
                v-if="scope.row.id !== 1"
              >
                <el-button
                  size="mini"
                  type="text"
                  icon="el-icon-edit"
                  @click="handleUpdate(scope.row)"
                  v-hasPermi="['system:grade:edit']"
                ></el-button>
              </el-tooltip>
              <el-tooltip
                content="删除"
                placement="top"
                v-if="scope.row.id !== 1"
              >
                <el-button
                  size="mini"
                  type="text"
                  icon="el-icon-delete"
                  @click="handleDelete(scope.row)"
                  v-hasPermi="['system:grade:remove']"
                  >删除</el-button
                >
              </el-tooltip>
            </template>
          </el-table-column>
        </el-table>

        <pagination
          v-show="total > 0"
          :total="total"
          v-model:page="queryParams.pageNum"
          v-model:limit="queryParams.pageSize"
          @pagination="getList"
        />
      </el-col>
    </el-row>

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="gradeRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学生学号" prop="userNumber">
          <el-input v-model="form.userNumber" placeholder="请输入学生学号" />
        </el-form-item>
        <el-form-item label="学生姓名" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入学生姓名" />
        </el-form-item>
        <el-form-item label="综合排名" prop="overallRank">
          <el-input v-model="form.overallRank" placeholder="请输入综合排名" />
        </el-form-item>
        <el-form-item label="综合分数" prop="overallScore">
          <el-input v-model="form.overallScore" placeholder="请输入综合分数" />
        </el-form-item>
        <el-form-item label="学习排名" prop="learnRank">
          <el-input v-model="form.learnRank" placeholder="请输入学习排名" />
        </el-form-item>
        <el-form-item label="学习分数" prop="learnScore">
          <el-input v-model="form.learnScore" placeholder="请输入学习分数" />
        </el-form-item>
        <el-form-item label="量化排名" prop="quantificationRank">
          <el-input
            v-model="form.quantificationRank"
            placeholder="请输入量化排名"
          />
        </el-form-item>
        <el-form-item label="量化分数" prop="quantificationScore">
          <el-input
            v-model="form.quantificationScore"
            placeholder="请输入量化分数"
          />
        </el-form-item>
        <el-form-item label="班级" prop="deptName">
          <el-input v-model="form.deptName" placeholder="请输入班级ID" />
        </el-form-item>
        <el-form-item label="学期" prop="semesterName">
          <el-input v-model="form.semesterName" placeholder="请输入学期ID" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>
  
  <script setup name="Grade">
import {
  listGrade,
  getGrade,
  delGrade,
  addGrade,
  updateGrade,
} from "@/api/system/grade";
import { deptTreeSelect } from "@/api/system/user";
import { ref } from "vue";
const { proxy } = getCurrentInstance();

// 遮罩层
const loading = ref(true);
// 选中数组
const ids = ref([]);
// 非单个禁用
const single = ref(true);
// 非多个禁用
const multiple = ref(true);
// 显示搜索条件
const showSearch = ref(true);
// 总条数
const total = ref(0);
// 【请填写功能名称】表格数据
const gradeList = ref([]);
// 弹出层标题
const title = ref("");
// 是否显示弹出层
const open = ref(false);
const hidden=ref(true);
const deptName = ref("");
const deptOptions = ref(undefined);

// 查询参数
const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    userNumber: null,
    userName: null,
    overallRank: null,
    overallScore: null,
    learnRank: null,
    learnScore: null,
    quantificationRank: null,
    quantificationScore: null,
    deptName: null,
    semesterName: null,
  },

  // 表单参数

  // 表单校验
  rules: {
    userNumber: [
      { required: true, message: "用户学号不能为空", trigger: "blur" },
    ],

    userName: [
      { required: true, message: "用户名称不能为空", trigger: "blur" },
    ],
    overallRank: [
      { required: true, message: "综合成绩排名不能为空", trigger: "blur" },
    ],
    overallScore: [
      { required: true, message: "综合成绩分数不能为空", trigger: "blur" },
    ],
    learnRank: [
      { required: true, message: "学习成绩分数不能为空", trigger: "blur" },
    ],
    learnScore: [
      { required: true, message: "学习成绩分数不能为空", trigger: "blur" },
    ],
    quantificationRank: [
      { required: true, message: "量化成绩分数不能为空", trigger: "blur" },
    ],
    quantificationScore: [
      { required: true, message: "量化成绩分数不能为空", trigger: "blur" },
    ],
    deptName: [{ required: true, message: "班级名不能为空", trigger: "blur" }],
    semesterName: [
      { required: true, message: "学期Id不能为空", trigger: "blur" },
    ],
  },
});
const { queryParams, form, rules } = toRefs(data);

const filterNode = (value, data) => {
  if (!value) return true;
  return data.label.indexOf(value) !== -1;
};
watch(deptName, (val) => {
  proxy.$refs["deptTreeRef"].filter(val);
});
function getDeptTree() {
  deptTreeSelect().then((response) => {
    deptOptions.value = response.data;
  });
}
/** 节点单击事件 */
function handleNodeClick(data) {
  queryParams.value.deptId = data.id;
  handleQuery();
};

/** 查询【请填写功能名称】列表 */
function getList() {
  loading.value = true;
  console.log("列表");
  listGrade(queryParams.value).then((response) => {
    console.log(response);
    gradeList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}
// 取消按钮
function cancel() {
  open.value = false;
  reset();
}
// 表单重置
function reset() {
  form.value = {
   
    id:undefined,
    userNumber: undefined,
    userName: undefined,
    overallRank: undefined,
    overallScore: undefined,
    learnRank: undefined,
    learnScore: undefined,
    quantificationRank: undefined,
    quantificationScore: undefined,
    deptName: undefined,
    semesterName: undefined,
    remark: undefined,
  };
  proxy.resetForm("gradeRef");
}
/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}
/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  handleQuery();
}
// 多选框选中数据
function handleSelectionChange(selection) {

  ids.value = selection.map(item => item.id);
  single.value = selection.length !== 1;
  multiple.value = !selection.length;
  console.log(ids.value);
}
/** 新增按钮操作 */
function handleAdd() {
  reset();

  open.value = true;
  console.log(open.value);
  title.value = "添加成绩";
}
/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const id = row.id || ids.value;
  console.log(id);
  getGrade(id).then((response) => {
    form.value = response.data;
    open.value = true;
    title.value = "修改成绩";
  });
}
/** 提交按钮 */
function submitForm() {
  proxy.$refs["gradeRef"].validate((valid) => {
    if (valid) {
      if (form.value.id != undefined) {
        updateGrade(form.value).then((response) => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addGrade(form.value).then((response) => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}
/** 删除按钮操作 */
function handleDelete(row) {
  const id = row.id || ids.value;
  proxy.$modal
    .confirm('是否确认删除成绩编号为"' + id + '"的数据项？')
    .then(function () {
      return delGrade(id);
    })
    .then(() => {
      getList();
      proxy.$modal.msgSuccess("删除成功");
    })
    .catch(() => {});
}
/** 导出按钮操作 */
function handleExport() {
  proxy.download(
    "system/grade/export",
    {
      ...queryParams.value,
    },
    `grade_${new Date().getTime()}.xlsx`
  );
}

getList();
getDeptTree();
</script>
  