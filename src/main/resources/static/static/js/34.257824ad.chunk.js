(this["webpackJsonpreact-demo"]=this["webpackJsonpreact-demo"]||[]).push([[34],{1250:function(e,t,o){var r=o(220);o(1251),o(1252),o(1253);var i=o(598),a=o(1254);r.registerVisual(i("tree","circle")),r.registerLayout(a)},1251:function(e,t,o){var r=o(272),i=o(719),a=o(247).encodeHTML,n=r.extend({type:"series.tree",layoutInfo:null,layoutMode:"box",getInitialData:function(e){var t={name:e.name,children:e.data},o=e.leaves||{},r={};r.leaves=o;var a=i.createTree(t,this,r,(function(e){e.wrapMethod("getItemModel",(function(e,t){var o=a.getNodeByDataIndex(t),r=o.getLeavesModel();return o.children.length&&o.isExpand||(e.parentModel=r),e}))})),n=0;a.eachNode("preorder",(function(e){e.depth>n&&(n=e.depth)}));var d=e.expandAndCollapse&&0<=e.initialTreeDepth?e.initialTreeDepth:n;return a.root.eachNode("preorder",(function(e){var t=e.hostTree.data.getRawDataItem(e.dataIndex);e.isExpand=t&&null!=t.collapsed?!t.collapsed:e.depth<=d})),a.data},getOrient:function(){var e=this.get("orient");return"horizontal"===e?e="LR":"vertical"===e&&(e="TB"),e},setZoom:function(e){this.option.zoom=e},setCenter:function(e){this.option.center=e},formatTooltip:function(e){for(var t=this.getData().tree,o=t.root.children[0],r=t.getNodeByDataIndex(e),i=r.getValue(),n=r.name;r&&r!==o;)n=r.parentNode.name+"."+n,r=r.parentNode;return a(n+(isNaN(i)||null==i?"":" : "+i))},defaultOption:{zlevel:0,z:2,coordinateSystem:"view",left:"12%",top:"12%",right:"12%",bottom:"12%",layout:"orthogonal",roam:!1,nodeScaleRatio:.4,center:null,zoom:1,orient:"LR",symbol:"emptyCircle",symbolSize:7,expandAndCollapse:!0,initialTreeDepth:2,lineStyle:{color:"#ccc",width:1.5,curveness:.5},itemStyle:{color:"lightsteelblue",borderColor:"#c23531",borderWidth:1.5},label:{show:!0,color:"#555"},leaves:{label:{show:!0}},animationEasing:"linear",animationDuration:700,animationDurationUpdate:1e3}});e.exports=n},1252:function(e,t,o){var r=o(216),i=o(222),a=o(659),n=o(851).radialCoordinate,d=o(220),l=o(653),h=o(718),s=o(715),p=o(636),c=o(664).onIrrelevantElement,u=d.extendChartView({type:"tree",init:function(e,t){this._oldTree,this._mainGroup=new i.Group,this._controller=new p(t.getZr()),this._controllerHost={target:this.group},this.group.add(this._mainGroup)},render:function(e,t,o){var r=e.getData(),i=e.layoutInfo,a=this._mainGroup,n=e.get("layout");"radial"===n?a.attr("position",[i.x+i.width/2,i.y+i.height/2]):a.attr("position",[i.x,i.y]),this._updateViewCoordSys(e,i,n),this._updateController(e,t,o);var d=this._data,l={expandAndCollapse:e.get("expandAndCollapse"),layout:n,orient:e.getOrient(),curvature:e.get("lineStyle.curveness"),symbolRotate:e.get("symbolRotate"),symbolOffset:e.get("symbolOffset"),hoverAnimation:e.get("hoverAnimation"),useNameLabel:!0,fadeIn:!0};r.diff(d).add((function(t){m(r,t)&&g(r,t,null,a,e,l)})).update((function(t,o){var i=d.getItemGraphicEl(o);m(r,t)?g(r,t,i,a,e,l):i&&y(d,o,i,a,e,l)})).remove((function(t){var o=d.getItemGraphicEl(t);o&&y(d,t,o,a,e,l)})).execute(),this._nodeScaleRatio=e.get("nodeScaleRatio"),this._updateNodeAndLinkScale(e),!0===l.expandAndCollapse&&r.eachItemGraphicEl((function(t,r){t.off("click").on("click",(function(){o.dispatchAction({type:"treeExpandAndCollapse",seriesId:e.id,dataIndex:r})}))})),this._data=r},_updateViewCoordSys:function(e){var t=e.getData(),o=[];t.each((function(e){var r=t.getItemLayout(e);!r||isNaN(r.x)||isNaN(r.y)||o.push([+r.x,+r.y])}));var r=[],i=[];l.fromPoints(o,r,i);var a=this._min,n=this._max;i[0]-r[0]==0&&(r[0]=a?a[0]:r[0]-1,i[0]=n?n[0]:i[0]+1),i[1]-r[1]==0&&(r[1]=a?a[1]:r[1]-1,i[1]=n?n[1]:i[1]+1);var d=e.coordinateSystem=new h;d.zoomLimit=e.get("scaleLimit"),d.setBoundingRect(r[0],r[1],i[0]-r[0],i[1]-r[1]),d.setCenter(e.get("center")),d.setZoom(e.get("zoom")),this.group.attr({position:d.position,scale:d.scale}),this._viewCoordSys=d,this._min=r,this._max=i},_updateController:function(e,t,o){var r=this._controller,i=this._controllerHost,a=this.group;r.setPointerChecker((function(t,r,i){var n=a.getBoundingRect();return n.applyTransform(a.transform),n.contain(r,i)&&!c(t,o,e)})),r.enable(e.get("roam")),i.zoomLimit=e.get("scaleLimit"),i.zoom=e.coordinateSystem.getZoom(),r.off("pan").off("zoom").on("pan",(function(t){s.updateViewOnPan(i,t.dx,t.dy),o.dispatchAction({seriesId:e.id,type:"treeRoam",dx:t.dx,dy:t.dy})}),this).on("zoom",(function(t){s.updateViewOnZoom(i,t.scale,t.originX,t.originY),o.dispatchAction({seriesId:e.id,type:"treeRoam",zoom:t.scale,originX:t.originX,originY:t.originY}),this._updateNodeAndLinkScale(e)}),this)},_updateNodeAndLinkScale:function(e){var t=e.getData(),o=this._getNodeGlobalScale(e),r=[o,o];t.eachItemGraphicEl((function(e,t){e.attr("scale",r)}))},_getNodeGlobalScale:function(e){var t=e.coordinateSystem;if("view"!==t.type)return 1;var o=this._nodeScaleRatio,r=t.scale,i=r&&r[0]||1;return((t.getZoom()-1)*o+1)/i},dispose:function(){this._controller&&this._controller.dispose(),this._controllerHost={}},remove:function(){this._mainGroup.removeAll(),this._data=null}});function m(e,t){var o=e.getItemLayout(t);return o&&!isNaN(o.x)&&!isNaN(o.y)&&"none"!==e.getItemVisual(t,"symbol")}function f(e,t,o){return o.itemModel=t,o.itemStyle=t.getModel("itemStyle").getItemStyle(),o.hoverItemStyle=t.getModel("emphasis.itemStyle").getItemStyle(),o.lineStyle=t.getModel("lineStyle").getLineStyle(),o.labelModel=t.getModel("label"),o.hoverLabelModel=t.getModel("emphasis.label"),!1===e.isExpand&&0!==e.children.length?o.symbolInnerColor=o.itemStyle.fill:o.symbolInnerColor="#fff",o}function g(e,t,o,n,d,l){var h=!o,s=e.tree.getNodeByDataIndex(t),p=s.getModel(),c=(l=f(s,p,l),e.tree.root),u=s.parentNode!==c&&s.parentNode||s,m=e.getItemGraphicEl(u.dataIndex),g=u.getLayout(),y=m?{x:m.position[0],y:m.position[1],rawX:m.__radialOldRawX,rawY:m.__radialOldRawY}:g,x=s.getLayout();h?(o=new a(e,t,l)).attr("position",[y.x,y.y]):o.updateData(e,t,l),o.__radialOldRawX=o.__radialRawX,o.__radialOldRawY=o.__radialRawY,o.__radialRawX=x.rawX,o.__radialRawY=x.rawY,n.add(o),e.setItemGraphicEl(t,o),i.updateProps(o,{position:[x.x,x.y]},d);var N=o.getSymbolPath();if("radial"===l.layout){var _,I,w=c.children[0],L=w.getLayout(),b=w.children.length;if(x.x===L.x&&!0===s.isExpand){var S={};S.x=(w.children[0].getLayout().x+w.children[b-1].getLayout().x)/2,S.y=(w.children[0].getLayout().y+w.children[b-1].getLayout().y)/2,(_=Math.atan2(S.y-L.y,S.x-L.x))<0&&(_=2*Math.PI+_),(I=S.x<L.x)&&(_-=Math.PI)}else(_=Math.atan2(x.y-L.y,x.x-L.x))<0&&(_=2*Math.PI+_),0===s.children.length||0!==s.children.length&&!1===s.isExpand?(I=x.x<L.x)&&(_-=Math.PI):(I=x.x>L.x)||(_-=Math.PI);var M=I?"left":"right",C=l.labelModel.get("rotate"),R=C*(Math.PI/180);N.setStyle({textPosition:l.labelModel.get("position")||M,textRotation:null==C?-_:R,textOrigin:"center",verticalAlign:"middle"})}if(s.parentNode&&s.parentNode!==c){var A=o.__edge;A=A||(o.__edge=new i.BezierCurve({shape:v(l,y,y),style:r.defaults({opacity:0,strokeNoScale:!0},l.lineStyle)})),i.updateProps(A,{shape:v(l,g,x),style:{opacity:1}},d),n.add(A)}}function y(e,t,o,r,a,n){for(var d,l=e.tree.getNodeByDataIndex(t),h=e.tree.root,s=l.getModel(),p=(n=f(l,s,n),l.parentNode!==h&&l.parentNode||l);null==(d=p.getLayout());)p=p.parentNode!==h&&p.parentNode||p;i.updateProps(o,{position:[d.x+1,d.y+1]},a,(function(){r.remove(o),e.setItemGraphicEl(t,null)})),o.fadeOut(null,{keepLabel:!0});var c=o.__edge;c&&i.updateProps(c,{shape:v(n,d,d),style:{opacity:0}},a,(function(){r.remove(c)}))}function v(e,t,o){var r,i,a,d,l,h,s,p,c=e.orient;if("radial"!==e.layout)return l=t.x,s=t.y,h=o.x,p=o.y,"LR"!==c&&"RL"!==c||(r=l+(h-l)*e.curvature,i=s,a=h+(l-h)*e.curvature,d=p),"TB"!==c&&"BT"!==c||(r=l,i=s+(p-s)*e.curvature,a=h,d=p+(s-p)*e.curvature),{x1:l,y1:s,x2:h,y2:p,cpx1:r,cpy1:i,cpx2:a,cpy2:d};l=t.rawX,s=t.rawY,h=o.rawX,p=o.rawY;var u=n(l,s),m=n(l,s+(p-s)*e.curvature),f=n(h,p+(s-p)*e.curvature),g=n(h,p);return{x1:u.x,y1:u.y,x2:g.x,y2:g.y,cpx1:m.x,cpy1:m.y,cpx2:f.x,cpy2:f.y}}e.exports=u},1253:function(e,t,o){var r=o(220),i=o(716).updateCenterAndZoom;r.registerAction({type:"treeExpandAndCollapse",event:"treeExpandAndCollapse",update:"update"},(function(e,t){t.eachComponent({mainType:"series",subType:"tree",query:e},(function(t){var o=e.dataIndex,r=t.getData().tree.getNodeByDataIndex(o);r.isExpand=!r.isExpand}))})),r.registerAction({type:"treeRoam",event:"treeRoam",update:"none"},(function(e,t){t.eachComponent({mainType:"series",subType:"tree",query:e},(function(t){var o=t.coordinateSystem,r=i(o,e);t.setCenter&&t.setCenter(r.center),t.setZoom&&t.setZoom(r.zoom)}))}))},1254:function(e,t,o){var r=o(1255),i=r.eachAfter,a=r.eachBefore,n=o(851),d=n.init,l=n.firstWalk,h=n.secondWalk,s=n.separation,p=n.radialCoordinate,c=n.getViewRect;e.exports=function(e,t){e.eachSeriesByType("tree",(function(e){!function(e,t){var o=c(e,t);e.layoutInfo=o;var r=e.get("layout"),n=0,u=0,m=null;m="radial"===r?(n=2*Math.PI,u=Math.min(o.height,o.width)/2,s((function(e,t){return(e.parentNode===t.parentNode?1:2)/e.depth}))):(n=o.width,u=o.height,s());var f=e.getData().tree.root,g=f.children[0];if(g){d(f),i(g,l,m),f.hierNode.modifier=-g.hierNode.prelim,a(g,h);var y=g,v=g,x=g;a(g,(function(e){var t=e.getLayout().x;t<y.getLayout().x&&(y=e),t>v.getLayout().x&&(v=e),e.depth>x.depth&&(x=e)}));var N=y===v?1:m(y,v)/2,_=N-y.getLayout().x,I=0,w=0,L=0,b=0;if("radial"===r)I=n/(v.getLayout().x+N+_),w=u/(x.depth-1||1),a(g,(function(e){L=(e.getLayout().x+_)*I,b=(e.depth-1)*w;var t=p(L,b);e.setLayout({x:t.x,y:t.y,rawX:L,rawY:b},!0)}));else{var S=e.getOrient();"RL"===S||"LR"===S?(w=u/(v.getLayout().x+N+_),I=n/(x.depth-1||1),a(g,(function(e){b=(e.getLayout().x+_)*w,L="LR"===S?(e.depth-1)*I:n-(e.depth-1)*I,e.setLayout({x:L,y:b},!0)}))):"TB"!==S&&"BT"!==S||(I=n/(v.getLayout().x+N+_),w=u/(x.depth-1||1),a(g,(function(e){L=(e.getLayout().x+_)*I,b="TB"===S?(e.depth-1)*w:u-(e.depth-1)*w,e.setLayout({x:L,y:b},!0)})))}}}(e,t)}))}},1255:function(e,t){t.eachAfter=function(e,t,o){for(var r,i=[e],a=[];r=i.pop();)if(a.push(r),r.isExpand){var n=r.children;if(n.length)for(var d=0;d<n.length;d++)i.push(n[d])}for(;r=a.pop();)t(r,o)},t.eachBefore=function(e,t){for(var o,r=[e];o=r.pop();)if(t(o),o.isExpand){var i=o.children;if(i.length)for(var a=i.length-1;0<=a;a--)r.push(i[a])}}},1256:function(e,t,o){var r=o(220);o(1257),o(1258),o(1261);var i=o(1262),a=o(1263);r.registerVisual(i),r.registerLayout(a)},1259:function(e,t,o){var r=o(222),i=o(240),a=o(216),n=o(600).wrapTreePathInfo;function d(e){this.group=new r.Group,e.add(this.group)}function l(e,t,o,r,i,a){var n=[[i?e:e-5,t],[e+o,t],[e+o,t+r],[i?e:e-5,t+r]];return a||n.splice(2,0,[e+o+5,t+r/2]),i||n.push([e,t+r/2]),n}d.prototype={constructor:d,render:function(e,t,o,r){var a=e.getModel("breadcrumb"),n=this.group;if(n.removeAll(),a.get("show")&&o){var d=a.getModel("itemStyle"),l=d.getModel("textStyle"),h={pos:{left:a.get("left"),right:a.get("right"),top:a.get("top"),bottom:a.get("bottom")},box:{width:t.getWidth(),height:t.getHeight()},emptyItemWidth:a.get("emptyItemWidth"),totalWidth:0,renderList:[]};this._prepare(o,h,l),this._renderContent(e,h,d,l,r),i.positionElement(n,h.pos,h.box)}},_prepare:function(e,t,o){for(var r=e;r;r=r.parentNode){var i=r.getModel().get("name"),a=o.getTextRect(i),n=Math.max(a.width+16,t.emptyItemWidth);t.totalWidth+=n+8,t.renderList.push({node:r,text:i,width:n})}},_renderContent:function(e,t,o,d,h){for(var s,p,c=0,u=t.emptyItemWidth,m=e.get("breadcrumb.height"),f=i.getAvailableSize(t.pos,t.box),g=t.totalWidth,y=t.renderList,v=y.length-1;0<=v;v--){var x=y[v],N=x.node,_=x.width,I=x.text;g>f.width&&(g-=_-u,_=u,I=null);var w=new r.Polygon({shape:{points:l(c,0,_,m,v===y.length-1,0===v)},style:a.defaults(o.getItemStyle(),{lineJoin:"bevel",text:I,textFill:d.getTextColor(),textFont:d.getFont()}),z:10,onclick:a.curry(h,N)});this.group.add(w),s=e,p=N,w.eventData={componentType:"series",componentSubType:"treemap",componentIndex:s.componentIndex,seriesIndex:s.componentIndex,seriesName:s.name,seriesType:"treemap",selfType:"breadcrumb",nodeData:{dataIndex:p&&p.dataIndex,name:p&&p.name},treePathInfo:p&&n(p,s)},c+=_+8}},remove:function(){this.group.removeAll()}};var h=d;e.exports=h},851:function(e,t,o){var r=o(240);function i(e){var t=e.children;return t.length&&e.isExpand?t[t.length-1]:e.hierNode.thread}function a(e){var t=e.children;return t.length&&e.isExpand?t[0]:e.hierNode.thread}function n(e,t,o){var r=o/(t.hierNode.i-e.hierNode.i);t.hierNode.change-=r,t.hierNode.shift+=o,t.hierNode.modifier+=o,t.hierNode.prelim+=o,e.hierNode.change+=r}function d(e,t){return e.parentNode===t.parentNode?1:2}t.init=function(e){e.hierNode={defaultAncestor:null,ancestor:e,prelim:0,modifier:0,change:0,shift:0,i:0,thread:null};for(var t,o,r=[e];t=r.pop();)if(o=t.children,t.isExpand&&o.length)for(var i=o.length-1;0<=i;i--){var a=o[i];a.hierNode={defaultAncestor:null,ancestor:a,prelim:0,modifier:0,change:0,shift:0,i:i,thread:null},r.push(a)}},t.firstWalk=function(e,t){var o=e.isExpand?e.children:[],r=e.parentNode.children,d=e.hierNode.i?r[e.hierNode.i-1]:null;if(o.length){!function(e){for(var t=e.children,o=t.length,r=0,i=0;0<=--o;){var a=t[o];a.hierNode.prelim+=r,a.hierNode.modifier+=r,i+=a.hierNode.change,r+=a.hierNode.shift+i}}(e);var l=(o[0].hierNode.prelim+o[o.length-1].hierNode.prelim)/2;d?(e.hierNode.prelim=d.hierNode.prelim+t(e,d),e.hierNode.modifier=e.hierNode.prelim-l):e.hierNode.prelim=l}else d&&(e.hierNode.prelim=d.hierNode.prelim+t(e,d));e.parentNode.hierNode.defaultAncestor=function(e,t,o,r){if(t){for(var d=e,l=e,h=l.parentNode.children[0],s=t,p=d.hierNode.modifier,c=l.hierNode.modifier,u=h.hierNode.modifier,m=s.hierNode.modifier;s=i(s),l=a(l),s&&l;){d=i(d),h=a(h),d.hierNode.ancestor=e;var f=s.hierNode.prelim+m-l.hierNode.prelim-c+r(s,l);0<f&&(n((y=e,v=o,(g=s).hierNode.ancestor.parentNode===y.parentNode?g.hierNode.ancestor:v),e,f),c+=f,p+=f),m+=s.hierNode.modifier,c+=l.hierNode.modifier,p+=d.hierNode.modifier,u+=h.hierNode.modifier}s&&!i(d)&&(d.hierNode.thread=s,d.hierNode.modifier+=m-p),l&&!a(h)&&(h.hierNode.thread=l,h.hierNode.modifier+=c-u,o=e)}var g,y,v;return o}(e,d,e.parentNode.hierNode.defaultAncestor||r[0],t)},t.secondWalk=function(e){var t=e.hierNode.prelim+e.parentNode.hierNode.modifier;e.setLayout({x:t},!0),e.hierNode.modifier+=e.parentNode.hierNode.modifier},t.separation=function(e){return arguments.length?e:d},t.radialCoordinate=function(e,t){var o={};return e-=Math.PI/2,o.x=t*Math.cos(e),o.y=t*Math.sin(e),o},t.getViewRect=function(e,t){return r.getLayoutRect(e.getBoxLayoutParams(),{width:t.getWidth(),height:t.getHeight()})}}}]);