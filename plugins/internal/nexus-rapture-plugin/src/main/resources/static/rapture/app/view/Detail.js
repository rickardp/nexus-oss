Ext.define('NX.view.Detail', {
  extend: 'Ext.panel.Panel',
  alias: 'widget.nxDetail',

  title: 'Empty Selection',

  layout: 'card',
  region: 'south',
  split: true,
  collapsible: true,
  flex: 0.5,
  activeItem: 0,

  initComponent: function () {
    var text = this.emptyText,
        content = this.items;

    if (!text) {
      text = 'Please select a ' + this.modelName + ' or create a new ' + this.modelName;
    }

    if (Ext.isArray(this.items) && this.items.length > 1) {
      content = {
        xtype: 'tabpanel',
        activeTab: 0,
        layoutOnTabChange: true,
        items: this.items
      }
    }

    this.items = [
      {
        xtype: 'panel',
        html: '<span class="nx-masterdetail-EmptySelection-text">' + text + '</span>'
      },
      content
    ];

    this.callParent(arguments);
  }

});
