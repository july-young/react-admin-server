(this["webpackJsonpreact-demo"]=this["webpackJsonpreact-demo"]||[]).push([[20],{1305:function(e,t,n){var i=n(220);n(1306),n(1307);var r=n(1308),a=n(1309);i.registerVisual(r),i.registerLayout(a)},1306:function(e,t,n){var i=n(216),r=n(272),a=n(859).seriesModelMixin,o=r.extend({type:"series.boxplot",dependencies:["xAxis","yAxis","grid"],defaultValueDimensions:[{name:"min",defaultTooltip:!0},{name:"Q1",defaultTooltip:!0},{name:"median",defaultTooltip:!0},{name:"Q3",defaultTooltip:!0},{name:"max",defaultTooltip:!0}],dimensions:null,defaultOption:{zlevel:0,z:2,coordinateSystem:"cartesian2d",legendHoverLink:!0,hoverAnimation:!0,layout:null,boxWidth:[7,50],itemStyle:{color:"#fff",borderWidth:1},emphasis:{itemStyle:{borderWidth:2,shadowBlur:5,shadowOffsetX:2,shadowOffsetY:2,shadowColor:"rgba(0,0,0,0.4)"}},animationEasing:"elasticOut",animationDuration:800}});i.mixin(o,a,!0);var l=o;e.exports=l},1307:function(e,t,n){var i=n(216),r=n(368),a=n(222),o=n(257),l=["itemStyle"],s=["emphasis","itemStyle"],u=r.extend({type:"boxplot",render:function(e){var t=e.getData(),n=this.group,i=this._data;this._data||n.removeAll();var r="horizontal"===e.get("layout")?1:0;t.diff(i).add((function(e){if(t.hasValue(e)){var i=d(t.getItemLayout(e),t,e,r,!0);t.setItemGraphicEl(e,i),n.add(i)}})).update((function(e,a){var o=i.getItemGraphicEl(a);if(t.hasValue(e)){var l=t.getItemLayout(e);o?p(l,o,t,e):o=d(l,t,e,r),n.add(o),t.setItemGraphicEl(e,o)}else n.remove(o)})).remove((function(e){var t=i.getItemGraphicEl(e);t&&n.remove(t)})).execute(),this._data=t},remove:function(){var e=this.group,t=this._data;this._data=null,t&&t.eachItemGraphicEl((function(t){t&&e.remove(t)}))},dispose:i.noop}),c=o.extend({type:"boxplotBoxPath",shape:{},buildPath:function(e,t){var n=t.points,i=0;for(e.moveTo(n[i][0],n[i][1]),i++;i<4;i++)e.lineTo(n[i][0],n[i][1]);for(e.closePath();i<n.length;i++)e.moveTo(n[i][0],n[i][1]),i++,e.lineTo(n[i][0],n[i][1])}});function d(e,t,n,r,a){var o,l,s,u=e.ends,d=new c({shape:{points:a?(o=u,l=r,s=e,i.map(o,(function(e){return(e=e.slice())[l]=s.initBaseline,e}))):u}});return p(e,d,t,n,a),d}function p(e,t,n,i,r){var o=n.hostModel;(0,a[r?"initProps":"updateProps"])(t,{shape:{points:e.ends}},o,i);var u=n.getItemModel(i),c=u.getModel(l),d=n.getItemVisual(i,"color"),p=c.getItemStyle(["borderColor"]);p.stroke=d,p.strokeNoScale=!0,t.useStyle(p),t.z2=100;var h=u.getModel(s).getItemStyle();a.setHoverStyle(t,h)}var h=u;e.exports=h},1308:function(e,t){var n=["itemStyle","borderColor"];e.exports=function(e,t){var i=e.get("color");e.eachRawSeriesByType("boxplot",(function(t){var r=i[t.seriesIndex%i.length],a=t.getData();a.setVisual({legendSymbol:"roundRect",color:t.get(n)||r}),e.isSeriesFiltered(t)||a.each((function(e){var t=a.getItemModel(e);a.setItemVisual(e,{color:t.get(n,!0)})}))}))}},1309:function(e,t,n){var i=n(216),r=n(224).parsePercent,a=i.each;e.exports=function(e){var t,n,o=(t=[],n=[],e.eachSeriesByType("boxplot",(function(e){var r=e.getBaseAxis(),a=i.indexOf(n,r);a<0&&(a=n.length,n[a]=r,t[a]={axis:r,seriesModels:[]}),t[a].seriesModels.push(e)})),t);a(o,(function(e){var t=e.seriesModels;t.length&&(function(e){var t,n,o=e.axis,l=e.seriesModels,s=l.length,u=e.boxWidthList=[],c=e.boxOffsetList=[],d=[];if("category"===o.type)n=o.getBandWidth();else{var p=0;a(l,(function(e){p=Math.max(p,e.getData().count())})),t=o.getExtent(),Math.abs(t[1]-t[0])}a(l,(function(e){var t=e.get("boxWidth");i.isArray(t)||(t=[t,t]),d.push([r(t[0],n)||0,r(t[1],n)||0])}));var h=.8*n-2,m=h/s*.3,g=(h-m*(s-1))/s,f=g/2-h/2;a(l,(function(e,t){c.push(f),f+=m+g,u.push(Math.min(Math.max(g,d[t][0]),d[t][1]))}))}(e),a(t,(function(t,n){!function(e,t,n){var i=e.coordinateSystem,r=e.getData(),a=n/2,o="horizontal"===e.get("layout")?0:1,l=1-o,s=["x","y"],u=r.mapDimension(s[o]),c=r.mapDimension(s[l],!0);if(!(null==u||c.length<5))for(var d=0;d<r.count();d++){var p=r.get(u,d),h=x(p,c[2],d),m=x(p,c[0],d),g=x(p,c[1],d),f=x(p,c[3],d),v=x(p,c[4],d),y=[];_(y,g,0),_(y,f,1),y.push(m,g,v,f),S(y,m),S(y,v),S(y,h),r.setItemLayout(d,{initBaseline:h[l],ends:y})}function x(e,n,a){var s,u=r.get(n,a),c=[];return c[o]=e,c[l]=u,isNaN(e)||isNaN(u)?s=[NaN,NaN]:(s=i.dataToPoint(c))[o]+=t,s}function _(e,t,n){var i=t.slice(),r=t.slice();i[o]+=a,r[o]-=a,n?e.push(i,r):e.push(r,i)}function S(e,t){var n=t.slice(),i=t.slice();n[o]-=a,i[o]+=a,e.push(n,i)}}(t,e.boxOffsetList[n],e.boxWidthList[n])})))}))}},1310:function(e,t,n){var i=n(220);n(1311),n(1312);var r=n(1313),a=n(1314),o=n(1315);i.registerPreprocessor(r),i.registerVisual(a),i.registerLayout(o)},1311:function(e,t,n){var i=n(216),r=n(272),a=n(859).seriesModelMixin,o=r.extend({type:"series.candlestick",dependencies:["xAxis","yAxis","grid"],defaultValueDimensions:[{name:"open",defaultTooltip:!0},{name:"close",defaultTooltip:!0},{name:"lowest",defaultTooltip:!0},{name:"highest",defaultTooltip:!0}],dimensions:null,defaultOption:{zlevel:0,z:2,coordinateSystem:"cartesian2d",legendHoverLink:!0,hoverAnimation:!0,layout:null,clip:!0,itemStyle:{color:"#c23531",color0:"#314656",borderWidth:1,borderColor:"#c23531",borderColor0:"#314656"},emphasis:{itemStyle:{borderWidth:2}},barMaxWidth:null,barMinWidth:null,barWidth:null,large:!0,largeThreshold:600,progressive:3e3,progressiveThreshold:1e4,progressiveChunkMode:"mod",animationUpdate:!1,animationEasing:"linear",animationDuration:300},getShadowDim:function(){return"open"},brushSelector:function(e,t,n){var i=t.getItemLayout(e);return i&&n.rect(i.brushRect)}});i.mixin(o,a,!0);var l=o;e.exports=l},1312:function(e,t,n){var i=n(216),r=n(368),a=n(222),o=n(257),l=n(631).createClipPath,s=["itemStyle"],u=["emphasis","itemStyle"],c=["color","color0","borderColor","borderColor0"],d=r.extend({type:"candlestick",render:function(e){this.group.removeClipPath(),this._updateDrawMode(e),this._isLargeDraw?this._renderLarge(e):this._renderNormal(e)},incrementalPrepareRender:function(e){this._clear(),this._updateDrawMode(e)},incrementalRender:function(e,t){this._isLargeDraw?this._incrementalRenderLarge(e,t):this._incrementalRenderNormal(e,t)},_updateDrawMode:function(e){var t=e.pipelineContext.large;(null==this._isLargeDraw||t^this._isLargeDraw)&&(this._isLargeDraw=t,this._clear())},_renderNormal:function(e){var t=e.getData(),n=this._data,i=this.group,r=t.getLayout("isSimpleBox"),o=e.get("clip",!0),l=e.coordinateSystem,s=l.getArea&&l.getArea();this._data||i.removeAll(),t.diff(n).add((function(n){if(t.hasValue(n)){var l,u=t.getItemLayout(n);if(o&&m(s,u))return;l=h(u,n,!0),a.initProps(l,{shape:{points:u.ends}},e,n),g(l,t,n,r),i.add(l),t.setItemGraphicEl(n,l)}})).update((function(l,u){var c=n.getItemGraphicEl(u);if(t.hasValue(l)){var d=t.getItemLayout(l);o&&m(s,d)?i.remove(c):(c?a.updateProps(c,{shape:{points:d.ends}},e,l):c=h(d,l),g(c,t,l,r),i.add(c),t.setItemGraphicEl(l,c))}else i.remove(c)})).remove((function(e){var t=n.getItemGraphicEl(e);t&&i.remove(t)})).execute(),this._data=t},_renderLarge:function(e){this._clear(),v(e,this.group);var t=e.get("clip",!0)?l(e.coordinateSystem,!1,e):null;t?this.group.setClipPath(t):this.group.removeClipPath()},_incrementalRenderNormal:function(e,t){for(var n,i=t.getData(),r=i.getLayout("isSimpleBox");null!=(n=e.next());){var a;g(a=h(i.getItemLayout(n),n),i,n,r),a.incremental=!0,this.group.add(a)}},_incrementalRenderLarge:function(e,t){v(t,this.group,!0)},remove:function(){this._clear()},_clear:function(){this.group.removeAll(),this._data=null},dispose:i.noop}),p=o.extend({type:"normalCandlestickBox",shape:{},buildPath:function(e,t){var n=t.points;this.__simpleBox?(e.moveTo(n[4][0],n[4][1]),e.lineTo(n[6][0],n[6][1])):(e.moveTo(n[0][0],n[0][1]),e.lineTo(n[1][0],n[1][1]),e.lineTo(n[2][0],n[2][1]),e.lineTo(n[3][0],n[3][1]),e.closePath(),e.moveTo(n[4][0],n[4][1]),e.lineTo(n[5][0],n[5][1]),e.moveTo(n[6][0],n[6][1]),e.lineTo(n[7][0],n[7][1]))}});function h(e,t,n){var r,a,o=e.ends;return new p({shape:{points:n?(r=o,a=e,i.map(r,(function(e){return(e=e.slice())[1]=a.initBaseline,e}))):o},z2:100})}function m(e,t){for(var n=!0,i=0;i<t.ends.length;i++)if(e.contain(t.ends[i][0],t.ends[i][1])){n=!1;break}return n}function g(e,t,n,i){var r=t.getItemModel(n),o=r.getModel(s),l=t.getItemVisual(n,"color"),d=t.getItemVisual(n,"borderColor")||l,p=o.getItemStyle(c);e.useStyle(p),e.style.strokeNoScale=!0,e.style.fill=l,e.style.stroke=d,e.__simpleBox=i;var h=r.getModel(u).getItemStyle();a.setHoverStyle(e,h)}var f=o.extend({type:"largeCandlestickBox",shape:{},buildPath:function(e,t){for(var n=t.points,i=0;i<n.length;)if(this.__sign===n[i++]){var r=n[i++];e.moveTo(r,n[i++]),e.lineTo(r,n[i++])}else i+=3}});function v(e,t,n){var i=e.getData(),r=i.getLayout("largePoints"),a=new f({shape:{points:r},__sign:1});t.add(a);var o=new f({shape:{points:r},__sign:-1});t.add(o),y(1,a,e,i),y(-1,o,e,i),n&&(a.incremental=!0,o.incremental=!0)}function y(e,t,n,i){var r=0<e?"P":"N",a=i.getVisual("borderColor"+r)||i.getVisual("color"+r),o=n.getModel(s).getItemStyle(c);t.useStyle(o),t.style.fill=null,t.style.stroke=a}var x=d;e.exports=x},1313:function(e,t,n){var i=n(216);e.exports=function(e){e&&i.isArray(e.series)&&i.each(e.series,(function(e){i.isObject(e)&&"k"===e.type&&(e.type="candlestick")}))}},1314:function(e,t,n){var i=n(610),r=["itemStyle","borderColor"],a=["itemStyle","borderColor0"],o=["itemStyle","color"],l=["itemStyle","color0"],s={seriesType:"candlestick",plan:i(),performRawSeries:!0,reset:function(e,t){var n=e.getData(),i=e.pipelineContext.large;if(n.setVisual({legendSymbol:"roundRect",colorP:s(1,e),colorN:s(-1,e),borderColorP:u(1,e),borderColorN:u(-1,e)}),!t.isSeriesFiltered(e))return!i&&{progress:function(e,t){for(var n;null!=(n=e.next());){var i=t.getItemModel(n),r=t.getItemLayout(n).sign;t.setItemVisual(n,{color:s(r,i),borderColor:u(r,i)})}}};function s(e,t){return t.get(0<e?o:l)}function u(e,t){return t.get(0<e?r:a)}}};e.exports=s},1315:function(e,t,n){var i=n(222).subPixelOptimize,r=n(610),a=n(224).parsePercent,o=n(216).retrieve2,l="undefined"!=typeof Float32Array?Float32Array:Array,s={seriesType:"candlestick",plan:r(),reset:function(e){var t,n,r,s,c,d,p,h,m=e.coordinateSystem,g=e.getData(),f=(n=g,c="category"===(s=(t=e).getBaseAxis()).type?s.getBandWidth():(r=s.getExtent(),Math.abs(r[1]-r[0])/n.count()),d=a(o(t.get("barMaxWidth"),c),c),p=a(o(t.get("barMinWidth"),1),c),null!=(h=t.get("barWidth"))?a(h,c):Math.max(Math.min(c/2,d),p)),v=["x","y"],y=g.mapDimension(v[0]),x=g.mapDimension(v[1],!0),_=x[0],S=x[1],b=x[2],I=x[3];if(g.setLayout({candleWidth:f,isSimpleBox:f<=1.3}),!(null==y||x.length<4))return{progress:e.pipelineContext.large?function(e,t){for(var n,i,r=new l(4*e.count),a=0,o=[],s=[];null!=(i=e.next());){var c=t.get(y,i),d=t.get(_,i),p=t.get(S,i),h=t.get(b,i),g=t.get(I,i);isNaN(c)||isNaN(h)||isNaN(g)?(r[a++]=NaN,a+=3):(r[a++]=u(t,i,d,p,S),o[0]=c,o[1]=h,n=m.dataToPoint(o,null,s),r[a++]=n?n[0]:NaN,r[a++]=n?n[1]:NaN,o[1]=g,n=m.dataToPoint(o,null,s),r[a++]=n?n[1]:NaN)}t.setLayout("largePoints",r)}:function(e,t){for(var n;null!=(n=e.next());){var r=t.get(y,n),a=t.get(_,n),o=t.get(S,n),l=t.get(b,n),s=t.get(I,n),c=Math.min(a,o),d=Math.max(a,o),p=P(c,r),h=P(d,r),g=P(l,r),v=P(s,r),x=[];w(x,h,0),w(x,p,1),x.push(D(v),D(h),D(g),D(p)),t.setItemLayout(n,{sign:u(t,n,a,o,S),initBaseline:o<a?h[1]:p[1],ends:x,brushRect:T(l,s,r)})}function P(e,t){var n=[];return n[0]=t,n[1]=e,isNaN(t)||isNaN(e)?[NaN,NaN]:m.dataToPoint(n)}function w(e,t,n){var r=t.slice(),a=t.slice();r[0]=i(r[0]+f/2,1,!1),a[0]=i(a[0]-f/2,1,!0),n?e.push(r,a):e.push(a,r)}function T(e,t,n){var i=P(e,n),r=P(t,n);return i[0]-=f/2,r[0]-=f/2,{x:i[0],y:i[1],width:f,height:r[1]-i[1]}}function D(e){return e[0]=i(e[0],1),e}}}}};function u(e,t,n,i,r){return i<n||!(n<i||!(0<t)||e.get(r,t-1)<=i)?-1:1}e.exports=s},1353:function(e,t,n){n(232).__DEV__;var i=n(216),r=n(222),a=n(712).getDefaultLabel,o=n(479),l=n(658).getLayoutOnAxis,s=n(597),u=n(272),c=n(263),d=n(368),p=n(631).createClipPath,h=n(1354),m=n(1355),g=n(1356),f=n(1357),v=n(1358),y=r.CACHED_LABEL_STYLE_PROPERTIES,x=["itemStyle"],_=["emphasis","itemStyle"],S=["label"],b=["emphasis","label"],I={cartesian2d:h,geo:m,singleAxis:g,polar:f,calendar:v};function P(e,t,n,i,r){null==n[e]||r||(t[e]=n[e],n[e]=i[e])}function w(e,t,n,o){var s=e.get("renderItem"),u=e.coordinateSystem,c={};u&&(c=u.prepareCustoms?u.prepareCustoms():I[u.type](u));var d,p,h,m,g,f,v,y=i.defaults({getWidth:o.getWidth,getHeight:o.getHeight,getZr:o.getZr,getDevicePixelRatio:o.getDevicePixelRatio,value:function(e,n){return null==n&&(n=h),t.get(t.getDimension(e||0),n)},style:function(n,o){null==o&&(o=h),T(o);var l=m.getModel(x).getItemStyle();null!=v&&(l.fill=v);var s=t.getItemVisual(o,"opacity");null!=s&&(l.opacity=s);var u=n?M(n,g):g;return r.setTextStyle(l,u,null,{autoColor:v,isRectText:!0}),l.text=u.getShallow("show")?i.retrieve2(e.getFormattedLabel(o,"normal"),a(t,o)):null,n&&N(l,n),l},styleEmphasis:function(n,o){null==o&&(o=h),T(o);var l=m.getModel(_).getItemStyle(),s=n?M(n,f):f;return r.setTextStyle(l,s,null,{isRectText:!0},!0),l.text=s.getShallow("show")?i.retrieve3(e.getFormattedLabel(o,"emphasis"),e.getFormattedLabel(o,"normal"),a(t,o)):null,n&&N(l,n),l},visual:function(e,n){return null==n&&(n=h),t.getItemVisual(n,e)},barLayout:function(e){if(u.getBaseAxis){var t=u.getBaseAxis();return l(i.defaults({axis:t},e),o)}},currentSeriesIndices:function(){return n.getCurrentSeriesIndices()},font:function(e){return r.getFont(e,n)}},c.api||{}),P={context:{},seriesId:e.id,seriesName:e.name,seriesIndex:e.seriesIndex,coordSys:c.coordSys,dataInsideLength:t.count(),encode:(d=e.getData(),p={},i.each(d.dimensions,(function(e,t){var n=d.getDimensionInfo(e);if(!n.isExtraCoord){var i=n.coordDim;(p[i]=p[i]||[])[n.coordDimIndex]=t}})),p)},w=!0;return function(e,n){return h=e,w=!0,s&&s(i.defaults({dataIndexInside:e,dataIndex:t.getRawIndex(e),actionType:n?n.type:null},P),y)};function T(e){null==e&&(e=h),w&&(m=t.getItemModel(e),g=m.getModel(S),f=m.getModel(b),v=t.getItemVisual(e,"color"),w=!1)}}function T(e,t,n,i,r,a){return(e=D(e,t,n,i,r,a,!0))&&a.setItemGraphicEl(t,e),e}function D(e,t,n,a,o,l,u){var c,d=!n,p=(n=n||{}).type,h=n.shape,m=n.style;if(e&&(d||null!=p&&p!==e.__customGraphicType||"path"===p&&(c=h)&&(c.hasOwnProperty("pathData")||c.hasOwnProperty("d"))&&E(h)!==e.__customPathData||"image"===p&&O(m,"image")&&m.image!==e.__customImagePath||"text"===p&&O(h,"text")&&m.text!==e.__customText)&&(o.remove(e),e=null),!d){var g=!e;return function(e,t,n,a,o,l){var s={},u=n.style||{};if(n.shape&&(s.shape=i.clone(n.shape)),n.position&&(s.position=n.position.slice()),n.scale&&(s.scale=n.scale.slice()),n.origin&&(s.origin=n.origin.slice()),n.rotation&&(s.rotation=n.rotation),"image"===e.type&&n.style){var c=s.style={};i.each(["x","y","width","height"],(function(t){P(t,c,u,e.style,o)}))}if("text"===e.type&&n.style&&(c=s.style={},i.each(["x","y"],(function(t){P(t,c,u,e.style,o)})),!u.hasOwnProperty("textFill")&&u.fill&&(u.textFill=u.fill),!u.hasOwnProperty("textStroke")&&u.stroke&&(u.textStroke=u.stroke)),"group"!==e.type&&(e.useStyle(u),o)){e.style.opacity=0;var d=u.opacity;null==d&&(d=1),r.initProps(e,{style:{opacity:d}},a,t)}o?e.attr(s):r.updateProps(e,s,a,t),n.hasOwnProperty("z2")&&e.attr("z2",n.z2||0),n.hasOwnProperty("silent")&&e.attr("silent",n.silent),n.hasOwnProperty("invisible")&&e.attr("invisible",n.invisible),n.hasOwnProperty("ignore")&&e.attr("ignore",n.ignore),n.hasOwnProperty("info")&&e.attr("info",n.info);var p=n.styleEmphasis;r.setElementHoverStyle(e,p),l&&r.setAsHighDownDispatcher(e,!1!==p)}(e=e||function(e){var t,n=e.type;if("path"===n){var i=e.shape,a=null!=i.width&&null!=i.height?{x:i.x||0,y:i.y||0,width:i.width,height:i.height}:null,o=E(i);(t=r.makePath(o,null,a,i.layout||"center")).__customPathData=o}else if("image"===n)(t=new r.Image({})).__customImagePath=e.style.image;else if("text"===n)(t=new r.Text({})).__customText=e.style.text;else if("group"===n)t=new r.Group;else{if("compoundPath"===n)throw new Error('"compoundPath" is not supported yet.');t=new(r.getShapeClass(n))}return t.__customGraphicType=n,t.name=e.name,t}(n),t,n,a,g,u),"group"===p&&function(e,t,n,i,r){var a=n.children,o=a?a.length:0,l=n.$mergeChildren,u="byName"===l||n.diffChildrenByName,c=!1===l;if(o||u||c){if(u)return function(e){new s(e.oldChildren,e.newChildren,C,C,e).add(L).update(L).remove(A).execute()}({oldChildren:e.children()||[],newChildren:a||[],dataIndex:t,animatableModel:i,group:e,data:r});c&&e.removeAll();for(var d=0;d<o;d++)a[d]&&D(e.childAt(d),t,a[d],i,e,r)}}(e,t,n,a,l),o.add(e),e}}function C(e,t){var n=e&&e.name;return null!=n?n:"e\0\0"+t}function L(e,t){var n=this.context,i=null!=e?n.newChildren[e]:null;D(null!=t?n.oldChildren[t]:null,n.dataIndex,i,n.animatableModel,n.group,n.data)}function M(e,t){var n=new c({},t);return i.each(y,(function(t,i){e.hasOwnProperty(t)&&(n.option[i]=e[t])})),n}function N(e,t){for(var n in t)!t.hasOwnProperty(n)&&y.hasOwnProperty(n)||(e[n]=t[n])}function A(e){var t=this.context,n=t.oldChildren[e];n&&t.group.remove(n)}function E(e){return e&&(e.pathData||e.d)}function O(e,t){return e&&e.hasOwnProperty(t)}u.extend({type:"series.custom",dependencies:["grid","polar","geo","singleAxis","calendar"],defaultOption:{coordinateSystem:"cartesian2d",zlevel:0,z:2,legendHoverLink:!0,useTransform:!0,clip:!1},getInitialData:function(){return o(this.getSource(),this)},getDataParams:function(e,t,n){var i=u.prototype.getDataParams.apply(this,arguments);return n&&(i.info=n.info),i}}),d.extend({type:"custom",_data:null,render:function(e,t,n,i){var r=this._data,a=e.getData(),o=this.group,l=w(e,a,t,n);a.diff(r).add((function(t){T(null,t,l(t,i),e,o,a)})).update((function(t,n){T(r.getItemGraphicEl(n),t,l(t,i),e,o,a)})).remove((function(e){var t=r.getItemGraphicEl(e);t&&o.remove(t)})).execute();var s=e.get("clip",!0)?p(e.coordinateSystem,!1,e):null;s?o.setClipPath(s):o.removeClipPath(),this._data=a},incrementalPrepareRender:function(){this.group.removeAll(),this._data=null},incrementalRender:function(e,t,n,i,r){var a=t.getData(),o=w(t,a,n,i);function l(e){e.isGroup||(e.incremental=!0,e.useHoverLayer=!0)}for(var s=e.start;s<e.end;s++)T(null,s,o(s,r),t,this.group,a).traverse(l)},dispose:i.noop,filterForExposedEvent:function(e,t,n){var i=t.element;if(null==i||n.name===i)return!0;for(;(n=n.parent)&&n!==this.group;)if(n.name===i)return!0;return!1}})}}]);