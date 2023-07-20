<template>
  <v-chart class="chart" :option="option" />
</template>

<script setup>
import { use } from "echarts/core";
import { CanvasRenderer } from "echarts/renderers";
import { PieChart } from "echarts/charts";
import {
  TitleComponent,
  TooltipComponent,
  LegendComponent
} from "echarts/components";
import VChart, { THEME_KEY } from "vue-echarts";
import { ref, provide,computed } from "vue";


use([
  CanvasRenderer,
  PieChart,
  TitleComponent,
  TooltipComponent,
  LegendComponent
]);

provide(THEME_KEY);

const data=ref([
  {value:10,name:'A'},
  {value:20,name:'B'},
  {value:30,name:'C'},
  {value:40,name:'D'},
  {value:50,name:'E'},
  {value:60,name:'F'},
])
// setInterval(()=>{
//   data.value=data.value.map(item=>({
//     ...item,
//     value:Math.random()*180,
//   }))
// },1000);
//computed计算属性
const option= computed(()=>{
  return {
    title: {
    text: "Traffic Sources",
    left: "center"
  },
  tooltip: {
    trigger: "item",
    formatter: "{a} <br/>{b} : {c} ({d}%)"
  },
  legend: {
    orient: "vertical",
    left: "left",
    data:data.value.map(d=>d.name),
  },
  series: [
    {
      name: "Traffic Sources",
      type: "pie",
      radius: "55%",
      center: ["50%", "60%"],
      data: data.value.map(d=>d.value),
      emphasis: {
        itemStyle: {
          shadowBlur: 10,
          shadowOffsetX: 0,
          shadowColor: "rgba(0, 0, 0, 0.5)"
        }
      }
    }
  ]
  }
  
})

</script>

<style scoped>
.chart {
  height: 400px;
}
</style>