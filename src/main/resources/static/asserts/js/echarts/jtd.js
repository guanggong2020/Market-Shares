$(function () {
    var labels = [];
    var datas1 = [];
    var datas2 = [];
    var datas3 = [];
    var datas4 = [];
    var datas5 = [];
    var datas6 = [];

    var tb = document.getElementById('tab');
    var rows = tb.rows;
    for (var i = rows.length - 1; i >= 0; i--) {
        labels.push(rows[i].cells[0].innerText);
        datas1.push(Number(rows[i].cells[3].innerText));
        datas2.push(Number(rows[i].cells[4].innerText));

    }
    var myLine = echarts.init(document.getElementById('line'));
     var myline1=echarts.init(document.getElementById('line1'));
    var lineOption = {
        title: {
            text: '基金走势图'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        legend: {
            data: ['单位净值']
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                data: labels
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '单位净值',
                type: 'line',
                stack: '总量',
                areaStyle: {},
                data: datas1
            }
        ]
    };

    var date = [];



    date=labels;

   var  lineOption1 = {
        tooltip: {
            trigger: 'axis',
            position: function (pt) {
                return [pt[0], '10%'];
            }
        },
        title: {
            left: 'center',
            text: '累计净值走势图',
        },
        toolbox: {
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: date
        },
        yAxis: {
            type: 'value',
        },
        dataZoom: [{
            type: 'inside',
            start: 0,
            end: 10
        }, {
            start: 0,
            end: 10,
            handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
            handleSize: '80%',
            handleStyle: {
                color: '#fff',
                shadowBlur: 3,
                shadowColor: 'rgba(0, 0, 0, 0.6)',
                shadowOffsetX: 2,
                shadowOffsetY: 2
            }
        }],
        series: [
            {
                name: '累计增值',
                type: 'line',
                stack: '总量',
                areaStyle: {
                },
                data: datas2
            }
        ]
    };

    myLine.setOption(lineOption,true);
    myline1.setOption(lineOption1,true);

})