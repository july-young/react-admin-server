(this["webpackJsonpreact-demo"]=this["webpackJsonpreact-demo"]||[]).push([[125,124],{225:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.create=t.connect=t.Provider=void 0;var o=i(n(456)),r=i(n(457)),a=i(n(459));function i(e){return e&&e.__esModule?e:{default:e}}t.Provider=o.default,t.connect=r.default,t.create=a.default},298:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.storeShape=void 0;var o,r=(o=n(1))&&o.__esModule?o:{default:o};t.storeShape=r.default.shape({subscribe:r.default.func.isRequired,setState:r.default.func.isRequired,getState:r.default.func.isRequired})},353:function(e,t,n){"use strict";n.r(t);var o,r=n(39),a=n.n(r),i=n(6),s=n.n(i),u=n(9),l=n.n(u),c=n(10),p=n.n(c),d=n(15),f=n.n(d),v=n(0),h=n.n(v),m=n(1),b=n.n(m),y=n(35),g=n.n(y),w=n(217),S=(o=v.Component,f()(E,o),E.getDerivedStateFromProps=function(e,t){return"checked"in e?s()({},t,{checked:e.checked}):null},E.prototype.focus=function(){this.input.focus()},E.prototype.blur=function(){this.input.blur()},E.prototype.render=function(){var e,t=this.props,n=t.prefixCls,o=t.className,r=t.style,i=t.name,u=t.id,l=t.type,c=t.disabled,p=t.readOnly,d=t.tabIndex,f=t.onClick,v=t.onFocus,m=t.onBlur,b=t.autoFocus,y=t.value,w=a()(t,["prefixCls","className","style","name","id","type","disabled","readOnly","tabIndex","onClick","onFocus","onBlur","autoFocus","value"]),S=Object.keys(w).reduce((function(e,t){return"aria-"!==t.substr(0,5)&&"data-"!==t.substr(0,5)&&"role"!==t||(e[t]=w[t]),e}),{}),E=this.state.checked,O=g()(n,o,((e={})[n+"-checked"]=E,e[n+"-disabled"]=c,e));return h.a.createElement("span",{className:O,style:r},h.a.createElement("input",s()({name:i,id:u,type:l,readOnly:p,disabled:c,tabIndex:d,className:n+"-input",checked:!!E,onClick:f,onFocus:v,onBlur:m,onChange:this.handleChange,autoFocus:b,ref:this.saveInput,value:y},S)),h.a.createElement("span",{className:n+"-inner"}))},E);function E(e){l()(this,E);var t=p()(this,o.call(this,e));t.handleChange=function(e){var n=t.props,o=n.disabled,r=n.onChange;o||("checked"in t.props||t.setState({checked:e.target.checked}),r&&r({target:s()({},t.props,{checked:e.target.checked}),stopPropagation:function(){e.stopPropagation()},preventDefault:function(){e.preventDefault()},nativeEvent:e.nativeEvent}))},t.saveInput=function(e){t.input=e};var n="checked"in e?e.checked:e.defaultChecked;return t.state={checked:n},t}S.propTypes={prefixCls:b.a.string,className:b.a.string,style:b.a.object,name:b.a.string,id:b.a.string,type:b.a.string,defaultChecked:b.a.oneOfType([b.a.number,b.a.bool]),checked:b.a.oneOfType([b.a.number,b.a.bool]),disabled:b.a.bool,onFocus:b.a.func,onBlur:b.a.func,onChange:b.a.func,onClick:b.a.func,tabIndex:b.a.oneOfType([b.a.string,b.a.number]),readOnly:b.a.bool,autoFocus:b.a.bool,value:b.a.any},S.defaultProps={prefixCls:"rc-checkbox",className:"",style:{},type:"checkbox",defaultChecked:!1,onFocus:function(){},onBlur:function(){},onChange:function(){}},Object(w.polyfill)(S);var O=S;t.default=O},370:function(e,t,n){"use strict";var o=n(4),r=n.n(o),a=n(6),i=n.n(a),s=n(9),u=n.n(s),l=n(11),c=n.n(l),p=n(10),d=n.n(p),f=n(15),v=n.n(f),h=n(0),m=n.n(h),b=n(1),y=n.n(b),g=n(217),w=n(455),S=n(35),E=n.n(S),O=n(252),k=n.n(O),C=!("undefined"==typeof window||!window.document||!window.document.createElement);function N(e,t){var n={};return n[e.toLowerCase()]=t.toLowerCase(),n["Webkit"+e]="webkit"+t,n["Moz"+e]="moz"+t,n["ms"+e]="MS"+t,n["O"+e]="o"+t.toLowerCase(),n}var x,j,P,T=(x=C,j="undefined"!=typeof window?window:{},P={animationend:N("Animation","AnimationEnd"),transitionend:N("Transition","TransitionEnd")},x&&("AnimationEvent"in j||delete P.animationend.animation,"TransitionEvent"in j||delete P.transitionend.transition),P),M={};C&&(M=document.createElement("div").style);var _={};function D(e){if(_[e])return _[e];var t=T[e];if(t)for(var n=Object.keys(t),o=n.length,r=0;r<o;r+=1){var a=n[r];if(Object.prototype.hasOwnProperty.call(t,a)&&a in M)return _[e]=t[a],_[e]}return""}var A=D("animationend"),R=D("transitionend"),L=!(!A||!R);function F(e,t){return e?"object"!=typeof e?e+"-"+t:e[t.replace(/-\w/g,(function(e){return e[1].toUpperCase()}))]:null}var I="none",U="appear",V="enter",W="leave",B={eventProps:y.a.object,visible:y.a.bool,children:y.a.func,motionName:y.a.oneOfType([y.a.string,y.a.object]),motionAppear:y.a.bool,motionEnter:y.a.bool,motionLeave:y.a.bool,motionLeaveImmediately:y.a.bool,removeOnLeave:y.a.bool,leavedClassName:y.a.string,onAppearStart:y.a.func,onAppearActive:y.a.func,onAppearEnd:y.a.func,onEnterStart:y.a.func,onEnterActive:y.a.func,onEnterEnd:y.a.func,onLeaveStart:y.a.func,onLeaveActive:y.a.func,onLeaveEnd:y.a.func};t.a=function(e){var t=e,n=!!m.a.forwardRef;function o(e){return e.motionName&&t}"object"==typeof e&&(t=e.transitionSupport,n="forwardRef"in e?e.forwardRef:n);var a,s=(a=m.a.Component,v()(l,a),c()(l,[{key:"componentDidMount",value:function(){this.onDomUpdate()}},{key:"componentDidUpdate",value:function(){this.onDomUpdate()}},{key:"componentWillUnmount",value:function(){this._destroyed=!0,this.removeEventListener(this.$cacheEle),this.cancelNextFrame()}},{key:"render",value:function(){var e,t=this.state,n=t.status,a=t.statusActive,s=t.statusStyle,u=this.props,l=u.children,c=u.motionName,p=u.visible,d=u.removeOnLeave,f=u.leavedClassName,v=u.eventProps;return l?n!==I&&o(this.props)?l(i()({},v,{className:E()((e={},r()(e,F(c,n),n!==I),r()(e,F(c,n+"-active"),n!==I&&a),r()(e,c,"string"==typeof c),e)),style:s}),this.setNodeRef):p?l(i()({},v),this.setNodeRef):d?null:l(i()({},v,{className:f}),this.setNodeRef):null}}],[{key:"getDerivedStateFromProps",value:function(e,t){var n=t.prevProps,r=t.status;if(!o(e))return{};var a=e.visible,i=e.motionAppear,s=e.motionEnter,u=e.motionLeave,l=e.motionLeaveImmediately,c={prevProps:e};return(r===U&&!i||r===V&&!s||r===W&&!u)&&(c.status=I,c.statusActive=!1,c.newStatus=!1),!n&&a&&i&&(c.status=U,c.statusActive=!1,c.newStatus=!0),n&&!n.visible&&a&&s&&(c.status=V,c.statusActive=!1,c.newStatus=!0),(n&&n.visible&&!a&&u||!n&&l&&!a&&u)&&(c.status=W,c.statusActive=!1,c.newStatus=!0),c}}]),l);function l(){u()(this,l);var e=d()(this,(l.__proto__||Object.getPrototypeOf(l)).call(this));return e.onDomUpdate=function(){var t=e.state,n=t.status,r=t.newStatus,a=e.props,i=a.onAppearStart,s=a.onEnterStart,u=a.onLeaveStart,l=a.onAppearActive,c=a.onEnterActive,p=a.onLeaveActive,d=a.motionAppear,f=a.motionEnter,v=a.motionLeave;if(o(e.props)){var h=e.getElement();e.$cacheEle!==h&&(e.removeEventListener(e.$cacheEle),e.addEventListener(h),e.$cacheEle=h),r&&n===U&&d?e.updateStatus(i,null,null,(function(){e.updateActiveStatus(l,U)})):r&&n===V&&f?e.updateStatus(s,null,null,(function(){e.updateActiveStatus(c,V)})):r&&n===W&&v&&e.updateStatus(u,null,null,(function(){e.updateActiveStatus(p,W)}))}},e.onMotionEnd=function(t){var n=e.state,o=n.status,r=n.statusActive,a=e.props,i=a.onAppearEnd,s=a.onEnterEnd,u=a.onLeaveEnd;o===U&&r?e.updateStatus(i,{status:I},t):o===V&&r?e.updateStatus(s,{status:I},t):o===W&&r&&e.updateStatus(u,{status:I},t)},e.setNodeRef=function(t){var n=e.props.internalRef;e.node=t,"function"==typeof n?n(t):n&&"current"in n&&(n.current=t)},e.getElement=function(){return Object(w.a)(e.node||e)},e.addEventListener=function(t){t&&(t.addEventListener(R,e.onMotionEnd),t.addEventListener(A,e.onMotionEnd))},e.removeEventListener=function(t){t&&(t.removeEventListener(R,e.onMotionEnd),t.removeEventListener(A,e.onMotionEnd))},e.updateStatus=function(t,n,o,r){var a=t?t(e.getElement(),o):null;if(!1!==a&&!e._destroyed){var s=void 0;r&&(s=function(){e.nextFrame(r)}),e.setState(i()({statusStyle:"object"==typeof a?a:null,newStatus:!1},n),s)}},e.updateActiveStatus=function(t,n){e.nextFrame((function(){e.state.status===n&&e.updateStatus(t,{statusActive:!0})}))},e.nextFrame=function(t){e.cancelNextFrame(),e.raf=k()(t)},e.cancelNextFrame=function(){e.raf&&(k.a.cancel(e.raf),e.raf=null)},e.state={status:I,statusActive:!1,newStatus:!1,statusStyle:null},e.$cacheEle=null,e.node=null,e.raf=null,e}return s.propTypes=i()({},B,{internalRef:y.a.oneOfType([y.a.object,y.a.func])}),s.defaultProps={visible:!0,motionEnter:!0,motionAppear:!0,motionLeave:!0,removeOnLeave:!0},Object(g.polyfill)(s),n?m.a.forwardRef((function(e,t){return m.a.createElement(s,i()({internalRef:t},e))})):s}(L)},456:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});function o(e,t){for(var n=0;n<t.length;n++){var o=t[n];o.enumerable=o.enumerable||!1,o.configurable=!0,"value"in o&&(o.writable=!0),Object.defineProperty(e,o.key,o)}}var r,a=n(0),i=((r=a)&&r.__esModule,n(298)),s=(function(e,t){if("function"!=typeof t&&null!==t)throw new TypeError("Super expression must either be null or a function, not "+typeof t);e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,enumerable:!1,writable:!0,configurable:!0}}),t&&(Object.setPrototypeOf?Object.setPrototypeOf(e,t):e.__proto__=t)}(u,a.Component),function(e,t,n){t&&o(e.prototype,t),n&&o(e,n)}(u,[{key:"getChildContext",value:function(){return{miniStore:this.props.store}}},{key:"render",value:function(){return a.Children.only(this.props.children)}}]),u);function u(){return function(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}(this,u),function(e,t){if(!e)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return!t||"object"!=typeof t&&"function"!=typeof t?e:t}(this,(u.__proto__||Object.getPrototypeOf(u)).apply(this,arguments))}s.propTypes={store:i.storeShape.isRequired},s.childContextTypes={miniStore:i.storeShape.isRequired},t.default=s},457:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var n=arguments[t];for(var o in n)Object.prototype.hasOwnProperty.call(n,o)&&(e[o]=n[o])}return e},r=function(e,t,n){return t&&a(e.prototype,t),n&&a(e,n),e};function a(e,t){for(var n=0;n<t.length;n++){var o=t[n];o.enumerable=o.enumerable||!1,o.configurable=!0,"value"in o&&(o.writable=!0),Object.defineProperty(e,o.key,o)}}t.default=function(e){var t=!!e,n=e||f;return function(a){var d,f=(function(e,t){if("function"!=typeof t&&null!==t)throw new TypeError("Super expression must either be null or a function, not "+typeof t);e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,enumerable:!1,writable:!0,configurable:!0}}),t&&(Object.setPrototypeOf?Object.setPrototypeOf(e,t):e.__proto__=t)}(v,i.Component),r(v,null,[{key:"getDerivedStateFromProps",value:function(t,o){return e&&2===e.length&&t!==o.props?{subscribed:n(o.store.getState(),t),props:t}:{props:t}}}]),r(v,[{key:"componentDidMount",value:function(){this.trySubscribe()}},{key:"componentWillUnmount",value:function(){this.tryUnsubscribe()}},{key:"shouldComponentUpdate",value:function(e,t){return!(0,u.default)(this.props,e)||!(0,u.default)(this.state.subscribed,t.subscribed)}},{key:"trySubscribe",value:function(){t&&(this.unsubscribe=this.store.subscribe(this.handleChange),this.handleChange())}},{key:"tryUnsubscribe",value:function(){this.unsubscribe&&(this.unsubscribe(),this.unsubscribe=null)}},{key:"getWrappedInstance",value:function(){return this.wrappedInstance}},{key:"render",value:function(){var e=this,t=o({},this.props,this.state.subscribed,{store:this.store});return a.prototype.render&&(t=o({},t,{ref:function(t){return e.wrappedInstance=t}})),s.default.createElement(a,t)}}]),v);function v(e,t){!function(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}(this,v);var o=function(e,t){if(e)return!t||"object"!=typeof t&&"function"!=typeof t?e:t;throw new ReferenceError("this hasn't been initialised - super() hasn't been called")}(this,(v.__proto__||Object.getPrototypeOf(v)).call(this,e,t));return o.handleChange=function(){if(o.unsubscribe){var e=n(o.store.getState(),o.props);o.setState({subscribed:e})}},o.store=t.miniStore,o.state={subscribed:n(o.store.getState(),e),store:o.store,props:e},o}return f.displayName="Connect("+((d=a).displayName||d.name||"Component")+")",f.contextTypes={miniStore:p.storeShape.isRequired},(0,c.polyfill)(f),(0,l.default)(f,a)}};var i=n(0),s=d(i),u=d(n(226)),l=d(n(458)),c=n(217),p=n(298);function d(e){return e&&e.__esModule?e:{default:e}}var f=function(){return{}}},458:function(e,t,n){"use strict";var o={childContextTypes:!0,contextTypes:!0,defaultProps:!0,displayName:!0,getDefaultProps:!0,getDerivedStateFromProps:!0,mixins:!0,propTypes:!0,type:!0},r={name:!0,length:!0,prototype:!0,caller:!0,callee:!0,arguments:!0,arity:!0},a=Object.defineProperty,i=Object.getOwnPropertyNames,s=Object.getOwnPropertySymbols,u=Object.getOwnPropertyDescriptor,l=Object.getPrototypeOf,c=l&&l(Object);e.exports=function e(t,n,p){if("string"==typeof n)return t;if(c){var d=l(n);d&&d!==c&&e(t,d,p)}var f=i(n);s&&(f=f.concat(s(n)));for(var v=0;v<f.length;++v){var h=f[v];if(!(o[h]||r[h]||p&&p[h])){var m=u(n,h);try{a(t,h,m)}catch(e){}}}return t}},459:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var n=arguments[t];for(var o in n)Object.prototype.hasOwnProperty.call(n,o)&&(e[o]=n[o])}return e};t.default=function(e){var t=e,n=[];return{setState:function(e){t=o({},t,e);for(var r=0;r<n.length;r++)n[r]()},getState:function(){return t},subscribe:function(e){return n.push(e),function(){var t=n.indexOf(e);n.splice(t,1)}}}}},464:function(e,t){window.MutationObserver=window.MutationObserver||function(e){function t(e){this.i=[],this.m=e}function n(t){var n,o={type:null,target:null,addedNodes:[],removedNodes:[],previousSibling:null,nextSibling:null,attributeName:null,attributeNamespace:null,oldValue:null};for(n in t)o[n]!==e&&t[n]!==e&&(o[n]=t[n]);return o}function o(t,o){var s=a(t,o);return function(l){var c,p,d,f,v=l.length;function h(e,t,o,a,i){var s,u,l,c=e.length-1;for(i=-~((c-i)/2);l=e.pop();)s=o[l.j],u=a[l.l],d.c&&i&&Math.abs(l.j-l.l)>=c&&(p.push(n({type:"childList",target:t,addedNodes:[s],removedNodes:[s],nextSibling:s.nextSibling,previousSibling:s.previousSibling})),i--),d.b&&u.b&&r(p,s,u.b,d.f),d.a&&3===s.nodeType&&s.nodeValue!==u.a&&p.push(n({type:"characterData",target:s,oldValue:u.a})),d.g&&m(s,u)}function m(t,o){for(var a,s,l,c,v,b=t.childNodes,y=o.c,g=b.length,w=y?y.length:0,S=0,E=0,O=0;E<g||O<w;)(c=b[E])===(v=(l=y[O])&&l.node)?(d.b&&l.b&&r(p,c,l.b,d.f),d.a&&l.a!==e&&c.nodeValue!==l.a&&p.push(n({type:"characterData",target:c,oldValue:l.a})),s&&h(s,t,b,y,S),d.g&&(c.childNodes.length||l.c&&l.c.length)&&m(c,l),E++,O++):(f=!0,a||(a={},s=[]),c&&(a[l=i(c)]||(a[l]=!0,-1===(l=u(y,c,O,"node"))?d.c&&(p.push(n({type:"childList",target:t,addedNodes:[c],nextSibling:c.nextSibling,previousSibling:c.previousSibling})),S++):s.push({j:E,l:l})),E++),v&&v!==b[E]&&(a[l=i(v)]||(a[l]=!0,-1===(l=u(b,v,E))?d.c&&(p.push(n({type:"childList",target:o.node,removedNodes:[v],nextSibling:y[O+1],previousSibling:y[O-1]})),S--):s.push({j:l,l:O})),O++));s&&h(s,t,b,y,S)}o.a&&3===t.nodeType&&t.nodeValue!==s.a&&l.push(new n({type:"characterData",target:t,oldValue:s.a})),o.b&&s.b&&r(l,t,s.b,o.f),(o.c||o.g)&&(p=l,d=o,m(t,s),c=f),!c&&l.length===v||(s=a(t,o))}}function r(t,o,r,a){for(var i,s,u={},l=o.attributes,p=l.length;p--;)s=(i=l[p]).name,a&&a[s]===e||(c(o,i)!==r[s]&&t.push(n({type:"attributes",target:o,attributeName:s,oldValue:r[s],attributeNamespace:i.namespaceURI})),u[s]=!0);for(s in r)u[s]||t.push(n({target:o,type:"attributes",attributeName:s,oldValue:r[s]}))}function a(e,t){var n=!0;return function e(o){var r={node:o};return!t.a||3!==o.nodeType&&8!==o.nodeType?(t.b&&n&&1===o.nodeType&&(r.b=s(o.attributes,(function(e,n){return t.f&&!t.f[n.name]||(e[n.name]=c(o,n)),e}))),n&&(t.c||t.a||t.b&&t.g)&&(r.c=function(e,t){for(var n=[],o=0;o<e.length;o++)n[o]=t(e[o],o,e);return n}(o.childNodes,e)),n=t.g):r.a=o.nodeValue,r}(e)}function i(e){try{return e.id||(e.mo_id=e.mo_id||p++)}catch(l){try{return e.nodeValue}catch(l){return p++}}}function s(e,t){for(var n={},o=0;o<e.length;o++)n=t(n,e[o],o,e);return n}function u(e,t,n,o){for(;n<e.length;n++)if((o?e[n][o]:e[n])===t)return n;return-1}t._period=30,t.prototype={observe:function(e,n){for(var r={b:!!(n.attributes||n.attributeFilter||n.attributeOldValue),c:!!n.childList,g:!!n.subtree,a:!(!n.characterData&&!n.characterDataOldValue)},a=this.i,i=0;i<a.length;i++)a[i].s===e&&a.splice(i,1);var u;n.attributeFilter&&(r.f=s(n.attributeFilter,(function(e,t){return e[t]=!0,e}))),a.push({s:e,o:o(e,r)}),this.h||(u=this,function e(){var n=u.takeRecords();n.length&&u.m(n,u),u.h=setTimeout(e,t._period)}())},takeRecords:function(){for(var e=[],t=this.i,n=0;n<t.length;n++)t[n].o(e);return e},disconnect:function(){this.i=[],clearTimeout(this.h),this.h=null}};var l=document.createElement("i");l.style.top=0;var c=(l="null"!=l.attributes.style.value)?function(e,t){return t.value}:function(e,t){return"style"!==t.name?t.value:e.style.cssText},p=1;return t}(void 0)},482:function(e,t,n){"use strict";n.r(t);var o,r=n(6),a=n.n(r),i=n(0),s=n(9),u=n.n(s),l=n(10),c=n.n(l),p=n(15),d=n.n(p),f=n(17),v=n(238),h=n(484),m=n(75);function b(){return u()(this,b),c()(this,o.apply(this,arguments))}var y=(o=i.Component,d()(b,o),b.prototype.shouldComponentUpdate=function(e){return!!e.forceRender||!!e.hiddenClassName||!!e.visible},b.prototype.render=function(){var e=this.props,t=e.className,n=e.hiddenClassName,o=e.visible,r=(e.forceRender,function(e,t){var n={};for(var o in e)Object.prototype.hasOwnProperty.call(e,o)&&t.indexOf(o)<0&&(n[o]=e[o]);if(null!=e&&"function"==typeof Object.getOwnPropertySymbols){var r=0;for(o=Object.getOwnPropertySymbols(e);r<o.length;r++)t.indexOf(o[r])<0&&(n[o[r]]=e[o[r]])}return n}(e,["className","hiddenClassName","visible","forceRender"])),s=t;return n&&!o&&(s+=" "+n),i.createElement("div",a()({},r,{className:s}))},b),g=0;function w(e,t){var n=e["page"+(t?"Y":"X")+"Offset"],o="scroll"+(t?"Top":"Left");if("number"!=typeof n){var r=e.document;"number"!=typeof(n=r.documentElement[o])&&(n=r.body[o])}return n}function S(e,t){var n=e.style;["Webkit","Moz","Ms","ms"].forEach((function(e){n[e+"TransformOrigin"]=t})),n.transformOrigin=t}var E,O=(E=i.Component,d()(k,E),k.prototype.componentDidMount=function(){this.componentDidUpdate({}),(this.props.forceRender||!1===this.props.getContainer&&!this.props.visible)&&this.wrap&&(this.wrap.style.display="none")},k.prototype.componentDidUpdate=function(e){var t,n,o,r,a,i=this.props,s=i.visible,u=i.mask,l=i.focusTriggerAfterClose,c=this.props.mousePosition;if(s){if(!e.visible){this.openTime=Date.now(),this.switchScrollingEffect(),this.tryFocus();var p=f.findDOMNode(this.dialog);if(c){var d=(o={left:(n=(t=p).getBoundingClientRect()).left,top:n.top},a=(r=t.ownerDocument).defaultView||r.parentWindow,o.left+=w(a),o.top+=w(a,!0),o);S(p,c.x-d.left+"px "+(c.y-d.top)+"px")}else S(p,"")}}else if(e.visible&&(this.inTransition=!0,u&&this.lastOutSideFocusNode&&l)){try{this.lastOutSideFocusNode.focus()}catch(e){this.lastOutSideFocusNode=null}this.lastOutSideFocusNode=null}},k.prototype.componentWillUnmount=function(){var e=this.props,t=e.visible,n=e.getOpenCount;!t&&!this.inTransition||n()||this.switchScrollingEffect(),clearTimeout(this.timeoutId)},k.prototype.tryFocus=function(){Object(h.a)(this.wrap,document.activeElement)||(this.lastOutSideFocusNode=document.activeElement,this.sentinelStart.focus())},k.prototype.render=function(){var e=this.props,t=e.prefixCls,n=e.maskClosable,o=this.getWrapStyle();return e.visible&&(o.display=null),i.createElement("div",{className:t+"-root"},this.getMaskElement(),i.createElement("div",a()({tabIndex:-1,onKeyDown:this.onKeyDown,className:t+"-wrap "+(e.wrapClassName||""),ref:this.saveRef("wrap"),onClick:n?this.onMaskClick:null,onMouseUp:n?this.onMaskMouseUp:null,role:"dialog","aria-labelledby":e.title?this.titleId:null,style:o},e.wrapProps),this.getDialogElement()))},k);function k(e){u()(this,k);var t=c()(this,E.call(this,e));return t.inTransition=!1,t.onAnimateLeave=function(){var e=t.props.afterClose;t.wrap&&(t.wrap.style.display="none"),t.inTransition=!1,t.switchScrollingEffect(),e&&e()},t.onDialogMouseDown=function(){t.dialogMouseDown=!0},t.onMaskMouseUp=function(){t.dialogMouseDown&&(t.timeoutId=setTimeout((function(){t.dialogMouseDown=!1}),0))},t.onMaskClick=function(e){Date.now()-t.openTime<300||e.target!==e.currentTarget||t.dialogMouseDown||t.close(e)},t.onKeyDown=function(e){var n=t.props;if(n.keyboard&&e.keyCode===v.a.ESC)return e.stopPropagation(),void t.close(e);if(n.visible&&e.keyCode===v.a.TAB){var o=document.activeElement,r=t.sentinelStart;e.shiftKey?o===r&&t.sentinelEnd.focus():o===t.sentinelEnd&&r.focus()}},t.getDialogElement=function(){var e=t.props,n=e.closable,o=e.prefixCls,r={};void 0!==e.width&&(r.width=e.width),void 0!==e.height&&(r.height=e.height);var s=void 0;e.footer&&(s=i.createElement("div",{className:o+"-footer",ref:t.saveRef("footer")},e.footer));var u=void 0;e.title&&(u=i.createElement("div",{className:o+"-header",ref:t.saveRef("header")},i.createElement("div",{className:o+"-title",id:t.titleId},e.title)));var l=void 0;n&&(l=i.createElement("button",{type:"button",onClick:t.close,"aria-label":"Close",className:o+"-close"},e.closeIcon||i.createElement("span",{className:o+"-close-x"})));var c=a()({},e.style,r),p={width:0,height:0,overflow:"hidden"},d=t.getTransitionName(),f=i.createElement(y,{key:"dialog-element",role:"document",ref:t.saveRef("dialog"),style:c,className:o+" "+(e.className||""),visible:e.visible,forceRender:e.forceRender,onMouseDown:t.onDialogMouseDown},i.createElement("div",{tabIndex:0,ref:t.saveRef("sentinelStart"),style:p,"aria-hidden":"true"}),i.createElement("div",{className:o+"-content"},l,u,i.createElement("div",a()({className:o+"-body",style:e.bodyStyle,ref:t.saveRef("body")},e.bodyProps),e.children),s),i.createElement("div",{tabIndex:0,ref:t.saveRef("sentinelEnd"),style:p,"aria-hidden":"true"}));return i.createElement(m.default,{key:"dialog",showProp:"visible",onLeave:t.onAnimateLeave,transitionName:d,component:"",transitionAppear:!0},e.visible||!e.destroyOnClose?f:null)},t.getZIndexStyle=function(){var e={},n=t.props;return void 0!==n.zIndex&&(e.zIndex=n.zIndex),e},t.getWrapStyle=function(){return a()({},t.getZIndexStyle(),t.props.wrapStyle)},t.getMaskStyle=function(){return a()({},t.getZIndexStyle(),t.props.maskStyle)},t.getMaskElement=function(){var e=t.props,n=void 0;if(e.mask){var o=t.getMaskTransitionName();n=i.createElement(y,a()({style:t.getMaskStyle(),key:"mask",className:e.prefixCls+"-mask",hiddenClassName:e.prefixCls+"-mask-hidden",visible:e.visible},e.maskProps)),o&&(n=i.createElement(m.default,{key:"mask",showProp:"visible",transitionAppear:!0,component:"",transitionName:o},n))}return n},t.getMaskTransitionName=function(){var e=t.props,n=e.maskTransitionName,o=e.maskAnimation;return!n&&o&&(n=e.prefixCls+"-"+o),n},t.getTransitionName=function(){var e=t.props,n=e.transitionName,o=e.animation;return!n&&o&&(n=e.prefixCls+"-"+o),n},t.close=function(e){var n=t.props.onClose;n&&n(e)},t.saveRef=function(e){return function(n){t[e]=n}},t.titleId="rcDialogTitle"+g++,t.switchScrollingEffect=e.switchScrollingEffect||function(){},t}var C=O;O.defaultProps={className:"",mask:!0,visible:!1,keyboard:!0,closable:!0,maskClosable:!0,destroyOnClose:!1,prefixCls:"rc-dialog",focusTriggerAfterClose:!0};var N=n(481);t.default=function(e){var t=e.visible,n=e.getContainer,o=e.forceRender;return!1===n?i.createElement(C,a()({},e,{getOpenCount:function(){return 2}})):i.createElement(N.a,{visible:t,forceRender:o,getContainer:n},(function(t){return i.createElement(C,a()({},e,t))}))}}}]);